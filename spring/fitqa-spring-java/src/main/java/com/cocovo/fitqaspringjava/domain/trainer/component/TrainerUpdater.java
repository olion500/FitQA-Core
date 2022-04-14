package com.cocovo.fitqaspringjava.domain.trainer.component;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;

import java.util.List;

public interface TrainerUpdater {
  boolean updateTrainerInterestAreas(Trainer trainer,
                                     List<WorkOutType.InterestArea> updateInterestAreas);

  boolean updateTrainerInfo(Trainer trainer, Trainer initUpdateTrainer);
}
