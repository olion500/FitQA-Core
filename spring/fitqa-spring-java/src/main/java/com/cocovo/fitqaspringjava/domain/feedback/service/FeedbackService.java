package com.cocovo.fitqaspringjava.domain.feedback.service;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackCommand;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;

import java.util.List;

public interface FeedbackService {

  List<FeedbackInfo.Main> retrieveFeedbacks();

  FeedbackInfo.Main retrieveFeedbackByToken(String feedbackToken);

  List<FeedbackInfo.Main> retrieveFeedbacksByTrainerId(Long trainerId);

  FeedbackInfo.Main registerFeedback(FeedbackCommand.RegisterFeedback command);

  String addComment(String feedbackToken, FeedbackCommand.AddComment command);
}
