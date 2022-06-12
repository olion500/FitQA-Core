package com.cocovo.fitqaspringjava.domain.trainer.component;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainerReader {

  Page<Trainer> retrieveTrainersAll(Pageable pageable);

  List<Trainer> retrieveTrainersByInterestAreas(List<WorkOutType.InterestArea> interestAreaList,
                                                Pageable pageable);

  Trainer retrieveTrainerByToken(String trainerToken);
  
  Trainer retrieveTrainerByEmail(String email);
}
