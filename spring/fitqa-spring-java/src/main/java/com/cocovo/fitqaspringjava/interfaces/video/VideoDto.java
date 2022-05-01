package com.cocovo.fitqaspringjava.interfaces.video;

import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

public class VideoDto {

    @Getter
    @Builder
    @ToString
    public static class VideoWaitingResponse {
        private String videoKey;
        private String feedbackToken;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }
}
