package com.cocovo.fitqaspringjava.domain.trainer.component;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;

import java.util.List;

public interface TrainerReader {

  List<Trainer> retrieveTrainersAll();

  List<Trainer> retrieveTrainersByInterestAreas(List<WorkOutType.InterestArea> interestAreaList);

  Trainer retrieveTrainerByToken(String trainerToken);
}
