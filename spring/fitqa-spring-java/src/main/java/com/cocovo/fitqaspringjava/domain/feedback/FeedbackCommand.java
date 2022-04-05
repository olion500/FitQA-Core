package com.cocovo.fitqaspringjava.domain.feedback;

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


    }
}
