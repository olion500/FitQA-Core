package com.cocovo.fitqaspringjava.domain.video.service;

import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;

public interface VideoService {
    VideoWaitingInfo.Main registerVideo(String videoKey, VideoCommand.Register command);

    VideoWaitingInfo.Main registerWaiting(String videoKey, String feedbackToken);
}
