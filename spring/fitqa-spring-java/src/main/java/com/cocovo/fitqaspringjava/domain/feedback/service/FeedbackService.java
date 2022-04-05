package com.cocovo.fitqaspringjava.domain.feedback.service;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;

import java.util.List;

public interface FeedbackService {

    List<FeedbackInfo> retrieveFeedbacks();
    FeedbackInfo retrieveFeedbackByToken(String feedbackToken);
}
