package com.cocovo.fitqaspringjava.infrastructure.trainer.repository;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
  Trainer getByTrainerToken(String trainerToken);

  List<Trainer> findAllByInterestAreasIn(List<WorkOutType.InterestArea> interestAreas);
}
