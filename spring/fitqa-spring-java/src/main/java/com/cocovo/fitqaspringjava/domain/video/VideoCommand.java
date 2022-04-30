package com.cocovo.fitqaspringjava.domain.video;

import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class VideoCommand {
    @Getter
    @Builder
    @ToString
    public static class Register {
        private String videoUrl;
        private String thumbnailUrl;
        private int width;
        private int height;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterFeedbackWaiting {
        private String feedbackToken;
        private String videoKey;

        public VideoFeedbackWaiting toEntity() {
            return VideoFeedbackWaiting.builder()
                    .feedbackToken(feedbackToken)
                    .videoKey(videoKey)
                    .build();
        }
    }
}
