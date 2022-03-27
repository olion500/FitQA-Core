package com.cocovo.fitqaspringjava.domain.trainer.component;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;

import java.util.List;

public interface TrainerReader {
  Trainer retrieveTrainerByToken(String trainerToken);

  List<Trainer> retrieveTrainerByInterestAreas(List<WorkOutType.InterestArea> interestAreaList);
}
