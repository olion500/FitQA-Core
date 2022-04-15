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
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Getter
@Entity
@Table(name = "trainers")
@DynamicUpdate
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

  private String representativeCareer;
  private String representativeFootprints;

  private Integer likesCount;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = {CascadeType.PERSIST,
      CascadeType.REMOVE})
  private List<TrainerImage> images = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = {CascadeType.PERSIST,
      CascadeType.REMOVE}, orphanRemoval = true)
  private List<TrainerCareer> careers = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = {CascadeType.PERSIST,
      CascadeType.REMOVE}, orphanRemoval = true)
  private List<TrainerFeedbackPrice> feedbackPrices = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = {CascadeType.PERSIST,
      CascadeType.REMOVE}, orphanRemoval = true)
  private List<TrainerInterestArea> interestAreas = Lists.newArrayList();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer", cascade = {CascadeType.PERSIST,
      CascadeType.REMOVE}, orphanRemoval = true)
  private List<TrainerSns> sns = Lists.newArrayList();

  @Builder
  public Trainer(String name, WorkOutType.Style style, String introduceTitle,
      String introduceContext, List<TrainerCareer> careers,
      List<TrainerFeedbackPrice> feedbackPrices, List<TrainerInterestArea> interestAreas,
      List<TrainerSns> sns) {
    if (StringUtils.isEmpty(name)) {
      throw new InvalidParamException("name is empty");
    }

    this.trainerToken = TokenGenerator.randomCharacterWithPrefix(TRAINER_PREFIX);
    this.name = name;
    this.style = style;
    this.introduceTitle = introduceTitle;
    this.introduceContext = introduceContext;
    this.careers = careers;
    this.feedbackPrices = feedbackPrices;
    this.interestAreas = interestAreas;
    this.sns = sns;
    this.likesCount = 0;
    this.representativeCareer = "";
    this.representativeFootprints = "";
  }

  public void addInterestArea(TrainerInterestArea newTrainerInterestArea) {
    interestAreas.add(newTrainerInterestArea);
  }

  public Trainer updateName(String name) {
    this.name = name;
    return this;
  }

  public Trainer updateStyle(WorkOutType.Style style) {
    this.style = style;
    return this;
  }

  public Trainer updateIntroduce(String introduceTitle, String introduceContext) {
    this.introduceTitle = introduceTitle;
    this.introduceContext = introduceContext;
    return this;
  }

  public Trainer updateCareers(List<TrainerCareer> newCareers) {
    deleteCareers();
    newCareers.forEach(trainerCareer -> {
      trainerCareer.setTrainer(this);
    });
    careers.addAll(newCareers);
    return this;
  }

  public Trainer updateFeedbackPrices(List<TrainerFeedbackPrice> newFeedbackPrices) {
    deleteFeedbackPrices();
    newFeedbackPrices.forEach(trainerFeedbackPrice -> {
      trainerFeedbackPrice.setTrainer(this);
    });
    feedbackPrices.addAll(newFeedbackPrices);
    return this;
  }

  public Trainer updateInterestAreas(List<TrainerInterestArea> newInterestAreas) {
    deleteInterestAreas();
    newInterestAreas.forEach(trainerInterestArea -> {
      trainerInterestArea.setTrainer(this);
    });
    interestAreas.addAll(newInterestAreas);
    return this;
  }

  public Trainer updateSns(List<TrainerSns> newSns) {
    deleteSns();
    newSns.forEach(trainerSns -> {
      trainerSns.setTrainer(this);
    });
    sns.addAll(newSns);
    return this;
  }

  public void deleteCareers() {
    Iterator<TrainerCareer> it = careers.iterator();

    while (it.hasNext()) {
      TrainerCareer next = it.next();
      next.setTrainer(null);
      it.remove();
    }
  }

  public void deleteFeedbackPrices() {
    Iterator<TrainerFeedbackPrice> it = feedbackPrices.iterator();

    while (it.hasNext()) {
      TrainerFeedbackPrice next = it.next();
      next.setTrainer(null);
      it.remove();
    }
  }

  public void deleteInterestAreas() {
    Iterator<TrainerInterestArea> it = interestAreas.iterator();

    while (it.hasNext()) {
      TrainerInterestArea next = it.next();
      next.setTrainer(null);
      it.remove();
    }
  }

  public void deleteSns() {
    Iterator<TrainerSns> it = sns.iterator();

    while (it.hasNext()) {
      TrainerSns next = it.next();
      next.setTrainer(null);
      it.remove();
    }
  }


}
