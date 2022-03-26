package com.cocovo.fitqaspringjava.domain.trainer;

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
    private final String name;
    private final WorkOutType.Style style;
    private final String introduceTitle;
    private final String introduceContext;
    private final Integer likesCount;
    private final List<TrainerImage> imageList;
    private final List<TrainerCareer> careerList;
    private final List<TrainerFeedbackPrice> feedbackPriceList;
    private final List<TrainerInterestArea> interestAreaList;
    private final List<TrainerSns> snsList;

    public static Main fromEntity(Trainer trainer) {
      return Main.builder().name(trainer.getName()).style(trainer.getStyle())
          .introduceTitle(trainer.getIntroduceTitle())
          .introduceContext(trainer.getIntroduceContext()).likesCount(trainer.getLikesCount())
          .imageList(trainer.getImageList()).careerList(trainer.getCareerList())
          .feedbackPriceList(trainer.getFeedbackPriceList())
          .interestAreaList(trainer.getInterestAreaList()).snsList(trainer.getSnsList()).build();
    }
  }
}
