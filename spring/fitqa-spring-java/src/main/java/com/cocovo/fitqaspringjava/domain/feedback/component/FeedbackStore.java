package com.cocovo.fitqaspringjava.domain.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;

public interface FeedbackStore {

  Feedback store(Feedback initFeedback);
}
