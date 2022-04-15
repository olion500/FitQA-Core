package com.cocovo.fitqaspringjava.interfaces.trainer.dto;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.trainer.entity.TrainerCareer;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TrainerDto {

  // Read
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

  // Update
  @Getter
  @ToString
  public static class UpdateTrainerInterestAreasRequest {

    private List<TypeInfo.InterestArea> interestAreas;
  }

  @Getter
  @ToString
  @RequiredArgsConstructor
  public static class UpdateTrainerInfoRequest {

    private String name;
    private TypeInfo.WorkOutStyle style;
    private String introduceTitle;
    private String introduceContext;
    private List<TrainerCareerInfo> careers;
    private List<TrainerFeedbackPriceInfo> feedbackPrices;
    private List<TrainerInterestAreaInfo> interestAreas;
    private List<TrainerSnsInfo> sns;
  }

  // Domain
  @Getter
  @ToString
  @Builder
  public static class Main {

    private final String trainerToken;
    private final String name;
    private final TypeInfo.WorkOutStyle style;
    private final String introduceTitle;
    private final String introduceContext;
    private final String representativeCareer;
    private final String representativeFootprints;
    private final Integer likesCount;
    private final List<TrainerImageInfo> images;
    private final List<TrainerCareerInfo> careers;
    private final List<TrainerFeedbackPriceInfo> feedbackPrices;
    private final List<TrainerInterestAreaInfo> interestAreas;
    private final List<TrainerSnsInfo> sns;
  }

  @Getter
  @ToString
  @Builder
  public static class TrainerImageInfo {

    private final String imageUrl;
    private final TypeInfo.ImageType imageType;
  }

  @Getter
  @ToString
  @Builder
  public static class TrainerCareerInfo {

    private final String description;
    private final TrainerCareer.Type type;
  }

  @Getter
  @ToString
  @Builder
  public static class TrainerFeedbackPriceInfo {

    private final TypeInfo.InterestArea area;
    private final Integer price;
  }

  @Getter
  @ToString
  public static class TrainerInterestAreaInfo {

    private TypeInfo.InterestArea interestArea;

    public TrainerInterestAreaInfo() {
    }

    public TrainerInterestAreaInfo(TypeInfo.InterestArea interestArea) {
      this.interestArea = interestArea;
    }

    public void setInterestArea(TypeInfo.InterestArea interestArea) {
      this.interestArea = interestArea;
    }
  }

  @Getter
  @ToString
  @Builder
  public static class TrainerSnsInfo {

    private final TypeInfo.SnsType snsType;
    private final String snsUrl;
  }
}