package com.cocovo.fitqaspringjava.domain.video.component;

import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;

public interface VideoStore {
    VideoFeedbackWaiting store(VideoFeedbackWaiting videoFeedbackWaiting);
}
