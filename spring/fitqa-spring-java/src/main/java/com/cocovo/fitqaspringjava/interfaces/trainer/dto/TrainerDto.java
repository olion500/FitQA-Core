package com.cocovo.fitqaspringjava.interfaces.trainer.dto;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;

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
    private TypeInfo.WorkOutStyle style;
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
    private final String trainerToken;
    private final String name;
    private final TypeInfo.WorkOutStyle style;
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
  @Builder
  @ToString
  public static class TrainerImageInfo {
    private final String imageUrl;
    private final TypeInfo.ImageType imageType;
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
    private final TypeInfo.InterestArea interestArea;
    private final Integer price;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerInterestAreaInfo {
    private final TypeInfo.InterestArea interestArea;
  }

  @Getter
  @Builder
  @ToString
  public static class TrainerSnsInfo {
    private final TypeInfo.SnsType snsType;
    private final String snsUrl;
  }
}