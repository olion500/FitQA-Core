package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo.TrainerWithFeedback;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainerService {

  // retrieve
  List<TrainerWithFeedback> retrieveTrainers(Pageable pageable);

  List<TrainerWithFeedback> retrieveTrainers(
      TrainerCommand.RetrieveTrainersByInterestAreas retrieveTrainersByInterestAreas, Pageable pageable);

  TrainerWithFeedback retrieveTrainerByToken(String trainerToken);

  TrainerInfo.Main retrieveTrainerByEmail(String email);

  // register
  String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer);

  // update
  TrainerWithFeedback updateTrainerInterestAreas(String trainerToken,
      TrainerCommand.UpdateTrainerByInterestAreas updateInterestAreas);

  TrainerWithFeedback updateTrainerInfo(String trainerToken,
      TrainerCommand.UpdateTrainerInfo updateTrainerInfo);
}
