package com.cocovo.fitqaspringjava.application.feedback;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackCommand;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;
import com.cocovo.fitqaspringjava.domain.feedback.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackFacade {
    private final FeedbackService feedbackService;

    public List<FeedbackInfo.Main> retrieveFeedbacks() {
        return feedbackService.retrieveFeedbacks();
    }

    public FeedbackInfo.Main retrieveFeedbackByToken(String feedbackToken) {
        return feedbackService.retrieveFeedbackByToken(feedbackToken);
    }

    public FeedbackInfo.Main registerFeedback(FeedbackCommand.RegisterFeedback command) {
        return feedbackService.registerFeedback(command);
    }

    public FeedbackInfo.Main addComment(String feedbackToken, FeedbackCommand.AddComment command) {
        feedbackService.addComment(feedbackToken, command);
        return feedbackService.retrieveFeedbackByToken(feedbackToken);
    }
}
