package com.cocovo.fitqaspringjava.domain.feedback;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackComment;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class FeedbackCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterFeedback {
        private String ownerId;
        private String trainerId;
        private TypeInfo.InterestArea interestArea;
        private Integer price;
        private String title;
        private String content;
        private boolean locked;

        public Feedback toEntity() {
            return Feedback.builder()
                    .ownerId(ownerId)
                    .trainerId(trainerId)
                    .interestArea(interestArea)
                    .price(price)
                    .title(title)
                    .content(content)
                    .locked(locked)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class AddComment {
        private String writerId;
        private String comment;

        public FeedbackComment toEntity(Feedback feedback) {
            return FeedbackComment.builder()
                    .feedback(feedback)
                    .writer(writerId)
                    .comment(comment)
                    .build();
        }
    }
}
