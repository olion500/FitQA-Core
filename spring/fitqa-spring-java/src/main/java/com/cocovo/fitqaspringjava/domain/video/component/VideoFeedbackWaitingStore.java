package com.cocovo.fitqaspringjava.domain.video.component;

import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;

public interface VideoFeedbackWaitingStore {
    VideoFeedbackWaiting store(String videoKey, String feedbackToken);
}
