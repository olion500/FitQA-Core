package com.cocovo.fitqaspringjava.domain.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackComment;

public interface FeedbackCommentStore {
    FeedbackComment store(FeedbackComment feedbackComment);
}
