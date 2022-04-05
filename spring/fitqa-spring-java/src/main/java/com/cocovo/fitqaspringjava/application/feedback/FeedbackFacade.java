package com.cocovo.fitqaspringjava.application.feedback;

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

    public List<FeedbackInfo> retrieveFeedbacks() {
        return feedbackService.retrieveFeedbacks();
    }

    public FeedbackInfo retrieveFeedbackByToken(String feedbackToken) {
        return feedbackService.retrieveFeedbackByToken(feedbackToken);
    }
}
