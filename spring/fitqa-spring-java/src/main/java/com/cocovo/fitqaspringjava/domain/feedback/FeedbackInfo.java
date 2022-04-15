package com.cocovo.fitqaspringjava.domain.feedback;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

public class FeedbackInfo {

  @Getter
  @Builder
  @ToString
  public static class Main {

    private final String feedbackToken;
    private final String ownerId;
    private final String trainerId;
    private final TypeInfo.InterestArea interestArea;
    private final Integer price;
    private final String title;
    private final String content;
    private final boolean locked;
    private final List<FeedbackCommentInfo> comments;
    private final Feedback.Status status;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
  }

  @Getter
  @ToString
  public static class FeedbackCommentInfo {

    private final String writer;
    private final String comment;

    public FeedbackCommentInfo(String writer, String comment) {
      this.writer = writer;
      this.comment = comment;
    }
  }
}
