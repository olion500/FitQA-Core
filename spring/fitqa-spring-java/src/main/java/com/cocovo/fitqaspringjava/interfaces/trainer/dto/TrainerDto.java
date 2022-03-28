package com.cocovo.fitqaspringjava.interfaces.trainer.dto;


import com.cocovo.fitqaspringjava.domain.common.entity.type.ImageType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.SnsType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TrainerDto {

  @Getter
  @ToString
  public static class RegisterTrainerRequest {
    @NotEmpty(message = "name 은 필수값입니다")
    private String name;
    @NotNull(message = "style 은 필수값입니다")
    private WorkOutType.Style style;
  }

  @Getter
  @Builder
  @ToString
  public static class RegisterTrainerResponse {
    private final String trainerToken;
  }

  @Getter
  @Builder
  @ToString
  public static class RetrieveTrainersRequest {
    private List<String> interestAreas;
  }

  @Getter
  @Builder
  @ToString
  public static class Main {
    private final String name;
    private final WorkOutType.Style style;
    private final String introduceTitle;
    private final String introduceContext;
    private final Integer likesCount;
    private final List<TrainerImage> images;
    private final List<TrainerCareer> careers;
    private final List<TrainerFeedbackPrice> feedbackPrices;
    private final List<TrainerInterestArea> interestAreas;
    private final List<TrainerSns> sns;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerImageInfo {
    private final String imageUrl;
    private final ImageType.Type imageType;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerCareerInfo {
    private final Long contestId;
    private final String awards;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerFeedbackPriceInfo {
    private final WorkOutType.InterestArea interestArea;
    private final Integer price;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerInterestAreaInfo {
    private final WorkOutType.InterestArea interestArea;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerSnsInfo {
    private final SnsType.Type snsType;
    private final String snsUrl;
  }
}