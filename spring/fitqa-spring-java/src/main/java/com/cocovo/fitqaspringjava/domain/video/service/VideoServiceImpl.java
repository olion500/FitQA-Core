package com.cocovo.fitqaspringjava.domain.video.service;

import com.cocovo.fitqaspringjava.domain.feedback.component.FeedbackReader;
import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import com.cocovo.fitqaspringjava.domain.video.VideoInfo;
import com.cocovo.fitqaspringjava.domain.video.VideoWaitingInfo;
import com.cocovo.fitqaspringjava.domain.video.component.VideoReader;
import com.cocovo.fitqaspringjava.domain.video.component.VideoStore;
import com.cocovo.fitqaspringjava.domain.video.component.VideoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoMapper videoMapper;

    private final VideoStore videoStore;
    private final VideoReader videoReader;

    private final FeedbackReader feedbackReader;


    @Override
    @Transactional
    public VideoInfo.Main registerVideo(String videoKey, VideoCommand.Register command) {
        // 1. find feedback id using videokey from video waiting.
        var feedbackWaiting= videoReader.findWaitingByVideoKey(videoKey);
        var feedback = feedbackReader.retrieveFeedbackByToken(feedbackWaiting.getFeedbackToken());

        // 2. add video to feedback
        var initVideo = command.toEntity(feedback);
        var video = videoStore.store(initVideo);

        // 3. change waiting status
        feedbackWaiting.changeDone();
        return videoMapper.of(video);
    }

    @Override
    @Transactional
    public VideoWaitingInfo.Main registerFeedbackWaiting(VideoCommand.RegisterFeedbackWaiting command) {
        var initVideoFeedbackWaiting = command.toEntity();
        var feedbackWaiting = videoStore.store(initVideoFeedbackWaiting);
        return videoMapper.of(feedbackWaiting);
    }
}
