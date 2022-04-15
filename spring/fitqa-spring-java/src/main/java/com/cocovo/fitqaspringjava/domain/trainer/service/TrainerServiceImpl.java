package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerReader;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerStore;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerUpdater;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import com.cocovo.fitqaspringjava.domain.trainer.mapper.TrainerInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

  private final TrainerStore trainerStore;
  private final TrainerReader trainerReader;
  private final TrainerUpdater trainerUpdater;
  private final TrainerInfoMapper trainerInfoMapper;

  @Override
  public String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer) {
    Trainer initTrainer = registerTrainer.toEntity();
    Trainer registeredTrainer = trainerStore.registerTrainer(initTrainer);

    return registeredTrainer.getTrainerToken();
  }

  @Override
  public TrainerInfo.Main retrieveTrainerByToken(String trainerToken) {
    Trainer foundTrainer = trainerReader.retrieveTrainerByToken(trainerToken);
    return trainerInfoMapper.of(foundTrainer);
  }

  @Override
  public List<TrainerInfo.Main> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas retrieveTrainersByInterestAreas) {
    List<Trainer> foundTrainers =
        trainerReader
            .retrieveTrainersByInterestAreas(retrieveTrainersByInterestAreas.getInterestAreas());

    return foundTrainers.stream().map(trainer -> trainerInfoMapper.of(trainer))
        .collect(Collectors.toUnmodifiableList());
  }

  @Override
  public List<TrainerInfo.Main> retrieveTrainers() {
    List<Trainer> foundTrainers = trainerReader.retrieveTrainersAll();

    return foundTrainers.stream().map(trainer -> trainerInfoMapper.of(trainer))
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public TrainerInfo.Main updateTrainerInterestAreas(String trainerToken,
      TrainerCommand.UpdateTrainerByInterestAreas updateInterestAreas) {
    var foundTrainer = trainerReader.retrieveTrainerByToken(trainerToken);
    trainerUpdater.updateTrainerInterestAreas(foundTrainer, updateInterestAreas.getInterestAreas());
    return trainerInfoMapper.of(foundTrainer);
  }

  @Override
  @Transactional
  public TrainerInfo.Main updateTrainerInfo(String trainerToken,
      TrainerCommand.UpdateTrainerInfo updateTrainerInfo) {
    var foundTrainer = trainerReader.retrieveTrainerByToken(trainerToken);
    var initUpdateTrainer = updateTrainerInfo.toEntity();
    trainerUpdater.updateTrainerInfo(foundTrainer, initUpdateTrainer);
    return trainerInfoMapper.of(foundTrainer);
  }
}
