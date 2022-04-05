package com.cocovo.fitqaspringjava.domain.feedback;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class FeedbackInfo {
    private final String feedbackToken;
    private final String title;
    private final String content;
    private final boolean locked;
    private final Feedback.Status status;
}
