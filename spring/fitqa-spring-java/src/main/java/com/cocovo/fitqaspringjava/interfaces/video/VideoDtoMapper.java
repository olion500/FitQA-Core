package com.cocovo.fitqaspringjava.interfaces.video;

import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;
import org.mapstruct.Mapper;

@Mapper
public interface VideoDtoMapper {
    VideoDto.VideoWaitingResponse of(VideoWaitingInfo.Main waitingInfo);
}
