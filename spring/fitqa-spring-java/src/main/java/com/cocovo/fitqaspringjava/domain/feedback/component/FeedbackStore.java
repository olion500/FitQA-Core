package com.cocovo.fitqaspringjava.domain.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackAnswer;

public interface FeedbackStore {

  Feedback store(Feedback initFeedback);

  FeedbackAnswer store(FeedbackAnswer initFeedbackAnswer);
}
