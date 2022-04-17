package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo.TrainerWithFeedback;
import java.util.List;

public interface TrainerService {

  // retrieve
  List<TrainerWithFeedback> retrieveTrainers();

  List<TrainerWithFeedback> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas retrieveTrainersByInterestAreas);

  TrainerWithFeedback retrieveTrainerByToken(String trainerToken);

  // register
  String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer);

  // update
  TrainerWithFeedback updateTrainerInterestAreas(String trainerToken,
      TrainerCommand.UpdateTrainerByInterestAreas updateInterestAreas);

  TrainerWithFeedback updateTrainerInfo(String trainerToken,
      TrainerCommand.UpdateTrainerInfo updateTrainerInfo);
}
