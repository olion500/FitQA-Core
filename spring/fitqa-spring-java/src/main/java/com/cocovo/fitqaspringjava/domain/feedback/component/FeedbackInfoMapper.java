package com.cocovo.fitqaspringjava.domain.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackAnswer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FeedbackInfoMapper {

  @Mapping(source = "feedbackCommentList", target = "comments")
  @Mapping(source = "feedbackAnswer", target = "answer")
  @Mapping(target = "trainerToken", expression = "java(feedback.getTrainer().getTrainerToken() != null ? feedback.getTrainer().getTrainerToken() : null)")
  FeedbackInfo.Main of(Feedback feedback);

  FeedbackInfo.FeedbackAnswerInfo of(FeedbackAnswer feedbackAnswer);
}
