package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerReader;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerStore;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerUpdater;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import com.cocovo.fitqaspringjava.domain.trainer.mapper.TrainerInfoMapper;
import com.cocovo.fitqaspringjava.domain.trainer.mapper.TrainerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {
  private final TrainerStore trainerStore;
  private final TrainerReader trainerReader;
  private final TrainerUpdater trainerUpdater;
  private final TrainerMapper trainerMapper;
  private final TrainerInfoMapper trainerInfoMapper;

  @Override
  public String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer) {
    Trainer initTrainer = registerTrainer.toEntity();
    Trainer registeredTrainer = trainerStore.registerTrainer(initTrainer);

    return registeredTrainer.getTrainerToken();
  }

  @Override
  public List<TrainerInfo.Main> retrieveTrainers() {
    List<Trainer> foundTrainers = trainerReader.retrieveTrainersAll();

    return foundTrainers.stream().map(trainer -> trainerInfoMapper.of(trainer))
        .collect(Collectors.toList());
  }

  @Override
  public List<TrainerInfo.Main> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas retrieveTrainersByInterestAreas) {
    var interestAreas = retrieveTrainersByInterestAreas.getInterestAreas().stream()
        .map(updateTrainerInterestArea -> trainerMapper.of(updateTrainerInterestArea)
            .getInterestArea()).collect(Collectors.toList());
    List<Trainer> foundTrainers = trainerReader
        .retrieveTrainersByInterestAreas(interestAreas);

    return foundTrainers.stream().map(trainer -> trainerInfoMapper.of(trainer))
        .collect(Collectors.toUnmodifiableList());
  }

  @Override
  public TrainerInfo.Main retrieveTrainerByToken(String trainerToken) {
    Trainer foundTrainer = trainerReader.retrieveTrainerByToken(trainerToken);
    return trainerInfoMapper.of(foundTrainer);
  }

  @Transactional
  @Override
  public TrainerInfo.Main updateTrainer(String trainerToken,
                                        TrainerCommand.UpdateTrainer updateTrainer) {
    Trainer storedTrainer = trainerReader.retrieveTrainerByToken(trainerToken);
    var updatedTrainer = trainerUpdater.updateTrainer(storedTrainer, updateTrainer);

    return trainerInfoMapper.of(updatedTrainer);
  }
}
