package com.cocovo.fitqaspringjava.infrastructure.feedback.component;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackStore;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.infrastructure.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeedbackStoreImpl implements FeedbackStore {
    private final FeedbackRepository feedbackRepository;
    @Override
    public Feedback store(Feedback feedback) {
        if (StringUtils.isEmpty(feedback.getTitle())) throw new InvalidParamException("feedback title cannot be null");
        if (StringUtils.isEmpty(feedback.getContent())) throw new InvalidParamException("feedback content cannot be null");

        return feedbackRepository.save(feedback);
    }
}
