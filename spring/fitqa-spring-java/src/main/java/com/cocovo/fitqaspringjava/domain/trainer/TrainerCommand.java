package com.cocovo.fitqaspringjava.domain.trainer;

import com.cocovo.fitqaspringjava.domain.common.entity.type.SnsType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class TrainerCommand {

  @Getter
  @Builder
  @ToString
  public static class RegisterTrainer {
    private final String name;
    private final WorkOutType.Style style;

    public Trainer toEntity() {
      return Trainer.builder().name(name).style(style).build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class RetrieveTrainersByInterestAreas {
    private final List<WorkOutType.InterestArea> interestAreas;
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerByInterestAreas {
    private final List<WorkOutType.InterestArea> interestAreas;
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerInfo {
    private final String name;
    private final WorkOutType.Style style;
    private final String introduceTitle;
    private final String introduceContext;
    private final List<UpdateTrainerCareer> careers;
    private final List<UpdateFeedbackPrice> feedbackPrices;
    private final List<UpdateInterestArea> interestAreas;
    private final List<UpdateSns> sns;

    public Trainer toEntity() {
      var trainerCareers = careers.isEmpty() ? null :
          careers.stream().map(updateTrainerCareer -> updateTrainerCareer.toEntity())
              .collect(Collectors.toList());
      var trainerFeedbackPrices = feedbackPrices.isEmpty() ? null :
          feedbackPrices.stream().map(updateFeedbackPrice -> updateFeedbackPrice.toEntity())
              .collect(Collectors.toList());
      var trainerInterestAreas = interestAreas.isEmpty() ? null :
          interestAreas.stream().map(updateInterestArea -> updateInterestArea.toEntity())
              .collect(Collectors.toList());
      var trainerSns =
          sns.stream().map(updateSns -> updateSns.toEntity()).collect(Collectors.toList());

      return Trainer.builder().name(name).style(style).introduceTitle(introduceTitle)
          .introduceContext(introduceContext).careers(trainerCareers)
          .feedbackPrices(trainerFeedbackPrices).interestAreas(trainerInterestAreas).sns(trainerSns)
          .build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateTrainerCareer {
    private final String description;
    private final TrainerCareer.Type type;

    public TrainerCareer toEntity() {
      return TrainerCareer.builder().description(description).type(type).build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateFeedbackPrice {
    private final WorkOutType.InterestArea area;
    private final Integer price;

    public TrainerFeedbackPrice toEntity() {
      return TrainerFeedbackPrice.builder().interestArea(area).price(price)
          .build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateInterestArea {
    private final WorkOutType.InterestArea interestArea;

    public TrainerInterestArea toEntity() {
      return TrainerInterestArea.builder().interestArea(interestArea).build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateSns {
    private final SnsType.Type snsType;
    private final String snsUrl;

    public TrainerSns toEntity() {
      return TrainerSns.builder().snsType(snsType).snsUrl(snsUrl).build();
    }
  }
}