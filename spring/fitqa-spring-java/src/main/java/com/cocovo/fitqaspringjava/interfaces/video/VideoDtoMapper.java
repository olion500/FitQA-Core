package com.cocovo.fitqaspringjava.interfaces.video;

import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface VideoDtoMapper {
    VideoDto.VideoWaitingResponse of(VideoWaitingInfo.Main waitingInfo);
}
