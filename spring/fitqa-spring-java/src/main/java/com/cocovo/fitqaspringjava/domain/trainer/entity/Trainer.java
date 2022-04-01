package com.cocovo.fitqaspringjava.domain.trainer.entity;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerCommand;
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
  public Trainer(String name, WorkOutType.Style style, String introduceTitle,
                 String introduceContext, Integer likesCount, List<TrainerImage> images,
                 List<TrainerCareer> careers, List<TrainerFeedbackPrice> feedbackPrices,
                 List<TrainerInterestArea> interestAreas, List<TrainerSns> sns) {
    this.trainerToken = TokenGenerator.randomCharacterWithPrefix(TRAINER_PREFIX);
    this.name = name;
    this.style = style;
    this.introduceTitle = introduceTitle;
    this.introduceContext = introduceContext;
    this.likesCount = likesCount;
    this.images = images;
    this.careers = careers;
    this.feedbackPrices = feedbackPrices;
    this.interestAreas = interestAreas;
    this.sns = sns;
  }

  public void changeIntroduce(String introduceTitle, String introduceContext) {
    this.introduceTitle = introduceTitle;
    this.introduceContext = introduceContext;
  }

  public void changeStyle(WorkOutType.Style style) {
    this.style = style;
  }

  public void increaseLikesCount() {
    ++this.likesCount;
  }

  public void decreaseLikesCount() {
    --this.likesCount;
  }

  public Trainer updateCareer(List<TrainerCareer> careers) {

    return this;
  }

  public Trainer updateFeedbackPrices(List<TrainerFeedbackPrice> feedbackPrices) {

    return this;
  }

  public Trainer updateInterestAreas(List<TrainerInterestArea> interestAreas) {
    return this;
  }

  public Trainer updateSns(List<TrainerSns> sns) {
    return this;
  }

  public void changeInterestAreas(List<WorkOutType.InterestArea> interestAreas) {
    for (var interestArea : interestAreas) {
      this.interestAreas.add(new TrainerInterestArea(this, interestArea));
    }
  }
}
