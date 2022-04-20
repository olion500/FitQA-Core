package com.cocovo.fitqaspringjava.infrastructure.feedback.component;

import com.cocovo.fitqaspringjava.common.exception.EntityNotFoundException;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackReader;
import com.cocovo.fitqaspringjava.infrastructure.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeedbackReaderImpl implements FeedbackReader {

  private final FeedbackRepository feedbackRepository;

  @Override
  public List<Feedback> retrieveFeedbackAll() {
    return feedbackRepository.findAll();
  }

  @Override
  public Feedback retrieveFeedbackByToken(String feedbackToken) {
    return feedbackRepository.findByFeedbackToken(feedbackToken)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public List<Feedback> retrieveFeedbackAllByTrainerId(Long trainerId) {
    return feedbackRepository.findAllByTrainerId(trainerId);
  }
}
