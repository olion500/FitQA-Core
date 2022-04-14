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

  private String description;

  @Enumerated(EnumType.STRING)
  private Type type;

  @Getter
  @RequiredArgsConstructor
  public enum Type {
    CAREER("경력"),
    LICENSE("학력 및 자격 면허");

    private final String description;
  }

  @Builder
  public TrainerCareer(Trainer trainer, String description, Type type) {
    if (StringUtils.isEmpty(description))
      throw new InvalidParamException("description is empty");
    this.trainer = trainer;
    this.description = description;
    this.type = type;
  }
}
