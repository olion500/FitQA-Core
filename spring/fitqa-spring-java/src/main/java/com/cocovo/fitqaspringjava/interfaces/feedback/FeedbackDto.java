package com.cocovo.fitqaspringjava.interfaces.feedback;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FeedbackDto {

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String feedbackToken;
        private final String title;
        private final String content;
        private final boolean locked;
        private final Feedback.Status status;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterReq {
        @NotEmpty(message = "title 은 필수값입니다.")
        private String title;
        @NotEmpty(message = "content 는 필수값입니다.")
        private String content;
        @NotNull(message = "locked 는 필수값입니다.")
        private boolean locked;
    }
}
