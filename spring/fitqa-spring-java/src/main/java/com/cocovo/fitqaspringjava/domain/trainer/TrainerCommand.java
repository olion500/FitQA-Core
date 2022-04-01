package com.cocovo.fitqaspringjava.domain.trainer;

import com.cocovo.fitqaspringjava.domain.common.entity.type.SnsType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class TrainerCommand {

  @Getter
  @Builder
  @ToString
  public static class RegisterTrainer {
    private final String name;
    private final WorkOutType.Style style;

    public Trainer toEntity() {
      return Trainer.builder().name(name).style(style).likesCount(0).build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class RetrieveTrainersByInterestAreas {
    private final List<UpdateTrainerInterestArea> interestAreas;
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainer {
    private final WorkOutType.Style style;
    private final String introduceTitle;
    private final String introduceContext;
    private final List<UpdateTrainerCareer> careers;
    private final List<UpdateTrainerFeedbackPrice> feedbackPrices;
    private final List<UpdateTrainerInterestArea> interestAreas;
    private final List<UpdateTrainerSns> sns;
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerCareer {
    private final Long contestId;
    private final String awards;
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerFeedbackPrice {
    private final WorkOutType.InterestArea interestArea;
    private final Integer price;
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerInterestArea {
    private final WorkOutType.InterestArea interestArea;

    public UpdateTrainerInterestArea(WorkOutType.InterestArea interestArea) {
      this.interestArea = interestArea;
    }

    public UpdateTrainerInterestArea(String description) {
      this.interestArea = WorkOutType.InterestArea.valueOf(description);
    }
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerSns {
    private final SnsType.Type snsType;
    private final String snsUrl;
  }
}
