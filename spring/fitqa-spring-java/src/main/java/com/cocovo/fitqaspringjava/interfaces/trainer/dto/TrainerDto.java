package com.cocovo.fitqaspringjava.interfaces.trainer.dto;


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
  public static class TrainerInfo {
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
}
