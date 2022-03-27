package com.cocovo.fitqaspringjava.domain.trainer.entity;

import com.google.common.collect.Lists;
import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@Table(name = "trainers")
@RequiredArgsConstructor
public class Trainer extends BaseEntity {
  private static final String TRAINER_PREFIX = "trn_";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String trainerToken;
  private String name;

  @Enumerated(EnumType.STRING)
  private WorkOutType.Style style;

  private String introduceTitle;
  private String introduceContext;
  private Integer likesCount;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = CascadeType.PERSIST)
  private List<TrainerImage> images = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = CascadeType.PERSIST)
  private List<TrainerCareer> careers = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = CascadeType.PERSIST)
  private List<TrainerFeedbackPrice> feedbackPrices = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = CascadeType.PERSIST)
  private List<TrainerInterestArea> interestAreas = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = CascadeType.PERSIST)
  private List<TrainerSns> sns = Lists.newArrayList();

  @Builder
  public Trainer(String name, WorkOutType.Style style) {
    if (StringUtils.isEmpty(name))
      throw new InvalidParamException("name is empty");

    this.trainerToken = TokenGenerator.randomCharacterWithPrefix(TRAINER_PREFIX);
    this.name = name;
    this.style = style;
  }
}
