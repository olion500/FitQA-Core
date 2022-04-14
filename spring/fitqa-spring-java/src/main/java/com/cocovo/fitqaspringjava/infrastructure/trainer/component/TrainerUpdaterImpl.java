package com.cocovo.fitqaspringjava.infrastructure.trainer.component;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerUpdater;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import com.cocovo.fitqaspringjava.domain.trainer.entity.TrainerInterestArea;
import com.cocovo.fitqaspringjava.infrastructure.trainer.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrainerUpdaterImpl implements TrainerUpdater {
  private final TrainerInterestAreaRepository trainerInterestAreaRepository;

  @Override
  public boolean updateTrainerInterestAreas(Trainer trainer,
                                            List<WorkOutType.InterestArea> updateInterestAreas) {
    var trainerInterestAreas = trainer.getInterestAreas();
    List<TrainerInterestArea> toBeDeleted = new ArrayList<>();

    trainerInterestAreas.removeIf(trainerInterestArea -> {
      if (!updateInterestAreas.contains(trainerInterestArea.getInterestArea())) {
        trainerInterestAreaRepository.delete(trainerInterestArea);
        return true;
      }
      updateInterestAreas.remove(trainerInterestArea.getInterestArea());
      return false;
    });

    for (var updateInterestArea : updateInterestAreas) {
      TrainerInterestArea newTrainerInterestArea =
          TrainerInterestArea.builder().trainer(trainer).interestArea(updateInterestArea).build();
      trainer.addInterestArea(newTrainerInterestArea);
      trainerInterestAreaRepository.save(newTrainerInterestArea);
    }
    return true;
  }

  @Override
  public boolean updateTrainerInfo(Trainer trainer, Trainer initUpdateTrainer) {
    trainer.updateName(initUpdateTrainer.getName())
        .updateStyle(initUpdateTrainer.getStyle())
        .updateIntroduce(initUpdateTrainer.getIntroduceTitle(), initUpdateTrainer
            .getIntroduceContext());

    trainer.updateCareers(initUpdateTrainer.getCareers())
        .updateFeedbackPrices(initUpdateTrainer.getFeedbackPrices())
        .updateInterestAreas(initUpdateTrainer.getInterestAreas())
        .updateSns(initUpdateTrainer.getSns());

    return true;
  }
}
