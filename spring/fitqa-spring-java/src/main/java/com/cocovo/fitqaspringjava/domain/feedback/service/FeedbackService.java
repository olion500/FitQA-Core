package com.cocovo.fitqaspringjava.domain.feedback.service;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackCommand;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;

import java.util.List;

public interface FeedbackService {

    List<FeedbackInfo> retrieveFeedbacks();
    FeedbackInfo retrieveFeedbackByToken(String feedbackToken);
    FeedbackInfo registerFeedback(FeedbackCommand.RegisterFeedback command);

    String addComment(String feedbackToken, FeedbackCommand.AddComment command);
}
