package com.cocovo.fitqaspringjava.domain.trainer.component;

import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;

public interface TrainerReader {
  Trainer getTrainerByToken(String trainerToken);
}
