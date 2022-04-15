package com.cocovo.fitqaspringjava.infrastructure.trainer.repository;

import com.cocovo.fitqaspringjava.domain.trainer.entity.TrainerInterestArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerInterestAreaRepository extends JpaRepository<TrainerInterestArea, Long> {

}
