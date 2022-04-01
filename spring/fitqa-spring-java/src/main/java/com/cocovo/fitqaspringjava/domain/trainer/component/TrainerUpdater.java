package com.cocovo.fitqaspringjava.domain.trainer.component;

import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;

import java.util.List;

public interface TrainerUpdater {
  Trainer updateTrainer(Trainer storedTrainer, TrainerCommand.UpdateTrainer updateTrainer);
}
