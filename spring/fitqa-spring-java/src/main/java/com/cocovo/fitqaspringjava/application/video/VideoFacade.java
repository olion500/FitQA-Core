package com.cocovo.fitqaspringjava.application.video;

import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import com.cocovo.fitqaspringjava.domain.video.VideoInfo;
import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;
import com.cocovo.fitqaspringjava.domain.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoFacade {

    private final VideoService videoService;

    public VideoInfo.Main registerVideo(String videoKey, VideoCommand.Register command) {
        return videoService.registerVideo(videoKey, command);
    }

    public VideoWaitingInfo.Main registerFeedbackWaiting(VideoCommand.RegisterFeedbackWaiting command) {
        return videoService.registerFeedbackWaiting(command);
    }
}
