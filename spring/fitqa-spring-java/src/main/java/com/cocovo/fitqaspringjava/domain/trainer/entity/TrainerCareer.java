package com.cocovo.fitqaspringjava.domain.trainer.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Table(name = "trainers_career")
@RequiredArgsConstructor
public class TrainerCareer extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "trainer_id")
  private Trainer trainer;

  private Long contestId;
  private String awards;

  @Builder
  public TrainerCareer(Trainer trainer, Long contestId, String awards) {
    if (StringUtils.isEmpty(awards))
      throw new InvalidParamException("awards is empty");
    this.trainer = trainer;
    this.contestId = contestId;
    this.awards = awards;
  }
}
