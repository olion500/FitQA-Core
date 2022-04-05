package com.cocovo.fitqaspringjava.domain.feedback;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class FeedbackCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterFeedback {
        private final String title;
        private final String content;
        private final boolean locked;

        public Feedback toEntity() {
            return Feedback.builder()
                    .title(title)
                    .content(content)
                    .locked(locked)
                    .build();
        }
    }
}
