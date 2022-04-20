package com.cocovo.fitqaspringjava.infrastructure.feedback.component;

import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackCommentStore;
import com.cocovo.fitqaspringjava.domain.feedback.entity.FeedbackComment;
import com.cocovo.fitqaspringjava.infrastructure.feedback.repository.FeedbackCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeedbackCommentStoreImpl implements FeedbackCommentStore {

  private final FeedbackCommentRepository feedbackCommentRepository;

  @Override
  public FeedbackComment store(FeedbackComment feedbackComment) {
    return feedbackCommentRepository.save(feedbackComment);
  }
}
