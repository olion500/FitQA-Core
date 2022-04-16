package com.cocovo.fitqaspringjava.interfaces.feedback;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

public class FeedbackDto {

    @Getter
    @Builder
    @ToString
    public static class RegisterReq {
        @NotEmpty(message = "ownerToken 은 필수값입니다.")
        private String ownerToken;
        @NotEmpty(message = "trainerToken 은 필수값입니다.")
        private String trainerToken;
        @NotNull(message = "interestArea 은 필수값입니다.")
        private TypeInfo.InterestArea interestArea;
        @NotNull(message = "price 은 필수값입니다.")
        private Integer price;
        @NotEmpty(message = "title 은 필수값입니다.")
        private String title;
        @NotEmpty(message = "content 는 필수값입니다.")
        private String content;
        @NotNull(message = "locked 는 필수값입니다.")
        private boolean locked;
    }

    @Getter
    @Builder
    @ToString
    public static class AddCommentReq {
        @NotEmpty(message = "writerId 는 필수값입니다")
        private String writerId;
        @NotEmpty(message = "comment 는 필수값입니다")
        private String comment;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterAnswerReq {
        @NotEmpty(message = "trainerToken 은 필수값입니다")
        private String trainerToken;
        @NotEmpty(message = "writerId 는 필수값입니다")
        private String videoUrl;
        @NotEmpty(message = "comment 는 필수값입니다")
        private String description;
    }

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String feedbackToken;
        private final String ownerToken;
        private final String trainerToken;
        private final TypeInfo.InterestArea interestArea;
        private final Integer price;
        private final String title;
        private final String content;
        private final boolean locked;
        private final List<FeedbackCommentInfo> comments;
        private final FeedbackAnswerInfo answer;
        private final Feedback.Status status;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }


    @Getter
    @Builder
    @ToString
    public static class FeedbackCommentInfo {
        private final String writer;
        private final String comment;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }

    @Getter
    @Builder
    @ToString
    public static class FeedbackAnswerInfo {
        private final String videoUrl;
        private final String description;
    }
}
