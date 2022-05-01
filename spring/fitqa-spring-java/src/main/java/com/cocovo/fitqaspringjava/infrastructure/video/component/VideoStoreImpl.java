package com.cocovo.fitqaspringjava.infrastructure.video.component;

import com.cocovo.fitqaspringjava.domain.video.component.VideoStore;
import com.cocovo.fitqaspringjava.domain.video.entity.Video;
import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import com.cocovo.fitqaspringjava.infrastructure.video.repository.VideoFeedbackWaitingRepository;
import com.cocovo.fitqaspringjava.infrastructure.video.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VideoStoreImpl implements VideoStore {

    private final VideoRepository videoRepository;
    private final VideoFeedbackWaitingRepository videoFeedbackWaitingRepository;

    @Override
    public Video store(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public VideoFeedbackWaiting store(VideoFeedbackWaiting videoFeedbackWaiting) {
        return videoFeedbackWaitingRepository.save(videoFeedbackWaiting);
    }
}
