package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;

import java.util.List;

public interface TrainerService {
  String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer);

  TrainerInfo.Main retrieveTrainerByToken(String trainerToken);

  List<TrainerInfo.Main> retrieveTrainers(TrainerCommand.RetrieveTrainers retrieveTrainers);
}
