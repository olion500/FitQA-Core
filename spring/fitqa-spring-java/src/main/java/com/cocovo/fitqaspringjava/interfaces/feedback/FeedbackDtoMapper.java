package com.cocovo.fitqaspringjava.interfaces.feedback;

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

    FeedbackDto of(FeedbackInfo feedbackInfo);
}
