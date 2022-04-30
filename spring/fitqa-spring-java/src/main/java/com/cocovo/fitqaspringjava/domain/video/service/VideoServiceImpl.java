package com.cocovo.fitqaspringjava.domain.video.service;

import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackReader;
import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import com.cocovo.fitqaspringjava.domain.video.VideoInfo;
import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;
import com.cocovo.fitqaspringjava.domain.video.component.VideoFeedbackWaitingReader;
import com.cocovo.fitqaspringjava.domain.video.component.VideoFeedbackWaitingStore;
import com.cocovo.fitqaspringjava.domain.video.component.VideoStore;
import com.cocovo.fitqaspringjava.domain.video.component.VideoWaitingMapper;
import com.cocovo.fitqaspringjava.domain.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoWaitingMapper videoWaitingMapper;

    private final VideoStore videoStore;
    private final VideoFeedbackWaitingStore videoFeedbackWaitingStore;

    private final FeedbackReader feedbackReader;
    private final VideoFeedbackWaitingReader videoFeedbackWaitingReader;


    @Override
    @Transactional
    public VideoWaitingInfo.Main registerVideo(String videoKey, VideoCommand.Register command) {
        // 1. find feedback id using videokey from video waiting.
        var feedbackWaiting= videoFeedbackWaitingReader.findWaitingByVideoKey(videoKey);
        var feedback = feedbackReader.retrieveFeedbackByToken(feedbackWaiting.getFeedbackToken());

        // 2. add video to feedback

        // 3. change waiting status
        feedbackWaiting.changeDone();
        return videoWaitingMapper.of(feedbackWaiting);
    }

    @Override
    @Transactional
    public VideoWaitingInfo.Main registerWaiting(String videoKey, String feedbackToken) {
        var feedbackWaiting = videoFeedbackWaitingStore.store(videoKey, feedbackToken);
        return videoWaitingMapper.of(feedbackWaiting);
    }
}
