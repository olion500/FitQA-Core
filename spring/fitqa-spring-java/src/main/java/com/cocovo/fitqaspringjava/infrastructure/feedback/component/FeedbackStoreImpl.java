package com.cocovo.fitqaspringjava.infrastructure.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackStore;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.infrastructure.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeedbackStoreImpl implements FeedbackStore {
    private final FeedbackRepository feedbackRepository;
    @Override
    public Feedback store(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
