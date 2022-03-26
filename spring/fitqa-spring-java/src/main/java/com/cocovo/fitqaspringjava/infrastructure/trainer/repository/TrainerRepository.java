package com.cocovo.fitqaspringjava.infrastructure.trainer.repository;

import com.cocovo.fitqaspringjava.domain.trainer.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
  Trainer getByTrainerToken(String trainerToken);
}
