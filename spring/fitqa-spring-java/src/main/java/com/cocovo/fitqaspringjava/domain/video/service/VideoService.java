package com.cocovo.fitqaspringjava.domain.video.service;

import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import com.cocovo.fitqaspringjava.domain.video.VideoInfo;
import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;

public interface VideoService {
    VideoInfo.Main registerVideo(String videoKey, VideoCommand.Register command);

    VideoWaitingInfo.Main registerFeedbackWaiting(VideoCommand.RegisterFeedbackWaiting command);
}
