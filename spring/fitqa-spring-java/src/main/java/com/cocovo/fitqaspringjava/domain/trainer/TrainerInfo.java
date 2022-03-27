package com.cocovo.fitqaspringjava.domain.trainer;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class TrainerInfo {

  @Getter
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

    public Main(Trainer trainer) {
      this.name = trainer.getName();
      this.style = trainer.getStyle();
      this.introduceTitle = trainer.getIntroduceTitle();
      this.introduceContext = trainer.getIntroduceContext();
      this.likesCount = trainer.getLikesCount();
      this.imageList = trainer.getImages();
      this.careerList = trainer.getCareers();
      this.feedbackPriceList = trainer.getFeedbackPrices();
      this.interestAreaList = trainer.getInterestAreas();
      this.snsList = trainer.getSns();
    }
  }
}
