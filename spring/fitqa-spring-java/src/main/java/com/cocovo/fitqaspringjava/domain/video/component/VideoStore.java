package com.cocovo.fitqaspringjava.domain.video.component;

import com.cocovo.fitqaspringjava.domain.video.entity.Video;
import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;

public interface VideoStore {
    Video store(Video video);
    VideoFeedbackWaiting store(VideoFeedbackWaiting videoFeedbackWaiting);
}
