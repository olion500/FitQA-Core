package com.cocovo.fitqaspringjava.infrastructure.trainer.component;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerReader;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import com.cocovo.fitqaspringjava.infrastructure.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrainerReaderImpl implements TrainerReader {
  private final TrainerRepository trainerRepository;

  @Override
  public Trainer retrieveTrainerByToken(String trainerToken) {
    return trainerRepository.getByTrainerToken(trainerToken);
  }

  @Override
  public List<Trainer> retrieveTrainerByInterestAreas(
      List<WorkOutType.InterestArea> interestAreaList) {
    return trainerRepository.findAllByInterestAreasIn(interestAreaList);
  }
}
