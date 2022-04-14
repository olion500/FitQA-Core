package com.cocovo.fitqaspringjava.domain.feedback.service;

import com.cocovo.fitqaspringjava.domain.feedback.FeedbackCommand;
import com.cocovo.fitqaspringjava.domain.feedback.FeedbackInfo;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackCommentStore;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackInfoMapper;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackReader;
import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackInfoMapper feedbackInfoMapper;

    private final FeedbackStore feedbackStore;
    private final FeedbackReader feedbackReader;
    private final FeedbackCommentStore feedbackCommentStore;

    @Override
    public List<FeedbackInfo.Main> retrieveFeedbacks() {
        var feedbacks = feedbackReader.retrieveFeedbackAll();
        return feedbacks.stream()
                .map(feedbackInfoMapper::of)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackInfo.Main retrieveFeedbackByToken(String feedbackToken) {
        var feedback = feedbackReader.retrieveFeedbackByToken(feedbackToken);
        return feedbackInfoMapper.of(feedback);
    }

    @Override
    public List<FeedbackInfo.Main> retrieveFeedbacksByTrainerId(Long trainerId) {
        var feedbacks = feedbackReader.retrieveFeedbackAllByTrainerId(trainerId);
        return feedbacks.stream()
                .map(feedbackInfoMapper::of)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackInfo.Main registerFeedback(FeedbackCommand.RegisterFeedback command) {
        var initFeedback = command.toEntity();
        var feedback = feedbackStore.store(initFeedback);
        return feedbackInfoMapper.of(feedback);
    }

    @Override
    public String addComment(String feedbackToken, FeedbackCommand.AddComment command) {
        var feedback = feedbackReader.retrieveFeedbackByToken(feedbackToken);
        var initComment = command.toEntity(feedback);
        var comment = feedbackCommentStore.store(initComment);
        return comment.getFeedbackCommentToken();
    }
}
