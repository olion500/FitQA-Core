package com.cocovo.fitqaspringjava.domain.feedback;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

public class FeedbackInfo {

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String feedbackToken;
        private final UserInfo.Main owner;
        private final FeedbackTrainer trainer;
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
    public static class FeedbackTrainer {
        private final Long id;
        private final String trainerToken;
        private final String name;
        private final String email;
        private final WorkOutType.Style style;
        private final String introduceTitle;
        private final String introduceContext;
        private final String representativeCareer;
        private final String representativeFootprints;
        private final Integer likesCount;
        private final List<TrainerInfo.TrainerImageInfo> images;
        private final List<TrainerInfo.TrainerCareerInfo> careers;
        private final List<TrainerInfo.TrainerFeedbackPriceInfo> feedbackPrices;
        private final List<TrainerInfo.TrainerInterestAreaInfo> interestAreas;
        private final List<TrainerInfo.TrainerSnsInfo> sns;
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class FeedbackCommentInfo {
        private final UserInfo.Main writer;
        private final String comment;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }

    @Getter
    @ToString
    public static class FeedbackAnswerInfo {
        private String videoUrl;
        private String description;

        public FeedbackAnswerInfo(String videoUrl, String description) {
            this.videoUrl = videoUrl;
            this.description = description;
        }
    }
}
