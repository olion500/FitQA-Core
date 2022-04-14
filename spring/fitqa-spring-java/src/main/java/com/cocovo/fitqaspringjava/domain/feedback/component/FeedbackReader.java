package com.cocovo.fitqaspringjava.domain.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;

import java.util.List;

public interface FeedbackReader {
    List<Feedback> retrieveFeedbackAll();

    Feedback retrieveFeedbackByToken(String feedbackToken);

    List<Feedback> retrieveFeedbackAllByTrainerId(Long trainerId);
}
