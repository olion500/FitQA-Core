package com.cocovo.fitqaspringjava.domain.trainer.entity;

import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Table(name = "trainers_feedback_price")
@RequiredArgsConstructor
public class TrainerFeedbackPrice extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "trainer_id")
  private Trainer trainer;

  @Enumerated(EnumType.STRING)
  private WorkOutType.InterestArea interestArea;
  private Integer price;

  public TrainerFeedbackPrice(Trainer trainer, WorkOutType.InterestArea interestArea,
                              Integer price) {
    this.trainer = trainer;
    this.interestArea = interestArea;
    this.price = price;
  }
}
