package com.cocovo.fitqaspringjava.domain.feedback.service;

import com.cocovo.fitqaspringjava.common.exception.FeedbackAnswerException;
import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackCommand;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackCommentStore;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackInfoMapper;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackReader;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackStore;
import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.trainer.component.TrainerReader;
import com.cocovo.fitqaspringjava.domain.user.component.UserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

  private final FeedbackInfoMapper feedbackInfoMapper;

  private final FeedbackStore feedbackStore;
  private final FeedbackReader feedbackReader;
  private final FeedbackCommentStore feedbackCommentStore;

  private final UserReader userReader;
  private final TrainerReader trainerReader;

  @Override
  @Transactional(readOnly = true)
  public List<FeedbackInfo.Main> retrieveFeedbacks() {
    var feedbacks = feedbackReader.retrieveFeedbackAll();
    return feedbacks.stream()
        .map(feedbackInfoMapper::of)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public FeedbackInfo.FeedbackAnswerInfo registerFeedbackAnswer(String feedbackToken,
      FeedbackCommand.RegisterFeedbackAnswer command) {
    var trainer = trainerReader.retrieveTrainerByToken(command.getTrainerToken());
    var feedback = feedbackReader.retrieveFeedbackByToken(feedbackToken);

    if (feedback.getFeedbackAnswer() != null) {
      throw new FeedbackAnswerException("이미 답변이 완료된 피드백입니다.");
    } else if (trainer.getId() != feedback.getTrainer().getId()) {
      throw new FeedbackAnswerException("잘못된 트레이너가 응답하였습니다.");
    }

    var initFeedbackAnswer = command.toEntity(feedback);
    feedbackStore.store(initFeedbackAnswer);
    feedback.changeComplete();
    return feedbackInfoMapper.of(initFeedbackAnswer);
  }

  @Override
  @Transactional(readOnly = true)
  public FeedbackInfo.Main retrieveFeedbackByToken(String feedbackToken) {
    var feedback = feedbackReader.retrieveFeedbackByToken(feedbackToken);
    return feedbackInfoMapper.of(feedback);
  }

  @Override
  @Transactional(readOnly = true)
  public List<FeedbackInfo.Main> retrieveFeedbacksByTrainerId(Long trainerId) {
    var feedbacks = feedbackReader.retrieveFeedbackAllByTrainerId(trainerId);
    return feedbacks.stream()
        .map(feedbackInfoMapper::of)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public FeedbackInfo.Main registerFeedback(FeedbackCommand.RegisterFeedback command) {
    var owner = userReader.retrieveUserByToken(command.getOwnerToken());
    var trainer = trainerReader.retrieveTrainerByToken(command.getTrainerToken());

    var initFeedback = command.toEntity(owner, trainer);
    owner.registerFeedback(initFeedback);
    trainer.registerFeedback(initFeedback);
    var feedback = feedbackStore.store(initFeedback);
    return feedbackInfoMapper.of(feedback);
  }

  @Override
  @Transactional
  public String addComment(String feedbackToken, FeedbackCommand.AddComment command) {
    var feedback = feedbackReader.retrieveFeedbackByToken(feedbackToken);
    var writer = userReader.retrieveUserByToken(command.getWriterToken());

    var initComment = command.toEntity(feedback, writer);
    var comment = feedbackCommentStore.store(initComment);
    return comment.getFeedbackCommentToken();
  }
}
