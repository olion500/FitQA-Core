package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;

import java.util.List;

public interface TrainerService {
  // retrieve
  List<TrainerInfo.Main> retrieveTrainers();

  List<TrainerInfo.Main> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas retrieveTrainersByInterestAreas);

  TrainerInfo.Main retrieveTrainerByToken(String trainerToken);

  // register
  String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer);

  // update
  TrainerInfo.Main updateTrainerInterestAreas(String trainerToken,
                                              TrainerCommand.UpdateTrainersByInterestAreas updateInterestAreas);
}
