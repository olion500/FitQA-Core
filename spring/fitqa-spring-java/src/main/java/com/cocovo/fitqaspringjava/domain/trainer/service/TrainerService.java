package com.cocovo.fitqaspringjava.domain.trainer.service;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;

public interface TrainerService {
  String registerTrainer(TrainerCommand.RegisterTrainer registerTrainer);
  TrainerInfo.Main getTrainerByToken(String trainerToken);
}
