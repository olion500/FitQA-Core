package com.cocovo.fitqaspringjava.interfaces.feedback;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackCommand;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FeedbackDtoMapper {

    FeedbackDto.Main of(FeedbackInfo.Main feedbackInfo);

    FeedbackDto.FeedbackAnswerInfo of(FeedbackInfo.FeedbackAnswerInfo feedbackAnswerInfo);

    FeedbackCommand.RegisterFeedback of(FeedbackDto.RegisterReq req);

    FeedbackCommand.RegisterFeedbackAnswer of(FeedbackDto.RegisterAnswerReq req);

    FeedbackCommand.AddComment of(FeedbackDto.AddCommentReq req);

}
