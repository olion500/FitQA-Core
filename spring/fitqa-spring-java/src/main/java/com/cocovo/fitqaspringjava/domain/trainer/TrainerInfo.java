package com.cocovo.fitqaspringjava.domain.trainer;

import com.cocovo.fitqaspringjava.domain.common.entity.type.ImageType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.SnsType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class TrainerInfo {

  @Getter
  @Builder
  @ToString
  public static class Main {
    private final String trainerToken;
    private final String name;
    private final WorkOutType.Style style;
    private final String introduceTitle;
    private final String introduceContext;
    private final Integer likesCount;
    private final List<TrainerImageInfo> images;
    private final List<TrainerCareerInfo> careers;
    private final List<TrainerFeedbackPriceInfo> feedbackPrices;
    private final List<TrainerInterestAreaInfo> interestAreas;
    private final List<TrainerSnsInfo> sns;
  }

  @Getter
  @ToString
  public static class TrainerImageInfo {
    private final String imageUrl;
    private final ImageType.Type imageType;

    public TrainerImageInfo(TrainerImage trainerImage) {
      this.imageUrl = trainerImage.getImageUrl();
      this.imageType = trainerImage.getImageType();
    }
  }

  @Getter
  @ToString
  public static class TrainerCareerInfo {
    private final Long contestId;
    private final String awards;

    public TrainerCareerInfo(TrainerCareer trainerCareer) {
      this.contestId = trainerCareer.getContestId();
      this.awards = trainerCareer.getAwards();
    }
  }

  @Getter
  @ToString
  public static class TrainerFeedbackPriceInfo {
    private final WorkOutType.InterestArea interestArea;
    private final Integer price;

    public TrainerFeedbackPriceInfo(TrainerFeedbackPrice trainerFeedbackPrice) {
      this.interestArea = trainerFeedbackPrice.getInterestArea();
      this.price = trainerFeedbackPrice.getPrice();
    }
  }

  @Getter
  @ToString
  public static class TrainerInterestAreaInfo {
    private final WorkOutType.InterestArea interestArea;

    public TrainerInterestAreaInfo(TrainerInterestArea trainerInterestArea) {
      this.interestArea = trainerInterestArea.getInterestArea();
    }
  }

  @Getter
  @ToString
  public static class TrainerSnsInfo {
    private final SnsType.Type snsType;
    private final String snsUrl;

    public TrainerSnsInfo(TrainerSns trainerSns) {
      this.snsType = trainerSns.getSnsType();
      this.snsUrl = trainerSns.getSnsUrl();
    }
  }
}
