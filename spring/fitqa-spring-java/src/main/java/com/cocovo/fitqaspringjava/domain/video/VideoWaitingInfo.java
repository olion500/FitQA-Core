package com.cocovo.fitqaspringjava.domain.video;

import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

public class VideoWaitingInfo {
    @Getter
    @Builder
    @ToString
    public static class Main {
        private String videoKey;
        private String feedbackToken;
        private VideoFeedbackWaiting.Status status;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }
}
