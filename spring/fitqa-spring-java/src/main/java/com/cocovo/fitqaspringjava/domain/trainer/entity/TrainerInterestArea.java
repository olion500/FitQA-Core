package com.cocovo.fitqaspringjava.domain.trainer.entity;

import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Table(name = "trainers_interest_area")
@RequiredArgsConstructor
public class TrainerInterestArea extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "trainer_id")
  private Trainer trainer;

  private WorkOutType.InterestArea interestArea;

  @Builder
  public TrainerInterestArea(Trainer trainer, WorkOutType.InterestArea interestArea) {
    this.trainer = trainer;
    this.interestArea = interestArea;
  }
}
