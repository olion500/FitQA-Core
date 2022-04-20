package com.cocovo.fitqaspringjava.domain.trainer.mapper;

import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackInfoMapper;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo.TrainerWithFeedback;
import com.cocovo.fitqaspringjava.domain.trainer.entity.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {FeedbackInfoMapper.class})
public interface TrainerInfoMapper {

  TrainerWithFeedback toWithFeedback(Trainer trainer);

  TrainerInfo.Main toMain(Trainer trainer);

  TrainerInfo.TrainerImageInfo of(TrainerImage trainerImage);

  TrainerInfo.TrainerCareerInfo of(TrainerCareer trainerCareer);

  TrainerInfo.TrainerFeedbackPriceInfo of(TrainerFeedbackPrice trainerFeedbackPrice);

  TrainerInfo.TrainerInterestAreaInfo of(TrainerInterestArea trainerInterestArea);

  TrainerInfo.TrainerSnsInfo of(TrainerSns trainerSns);
}
