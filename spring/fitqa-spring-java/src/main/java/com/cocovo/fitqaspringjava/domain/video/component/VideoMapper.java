package com.cocovo.fitqaspringjava.domain.video.component;

import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;
import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VideoMapper {
    VideoWaitingInfo.Main of(VideoFeedbackWaiting videoWaiting);
}
