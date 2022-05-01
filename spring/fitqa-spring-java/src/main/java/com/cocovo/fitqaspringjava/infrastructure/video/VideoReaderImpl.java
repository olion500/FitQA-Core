package com.cocovo.fitqaspringjava.infrastructure.video;

import com.cocovo.fitqaspringjava.common.exception.EntityNotFoundException;
import com.cocovo.fitqaspringjava.common.exception.VideoNotRegisteredException;
import com.cocovo.fitqaspringjava.domain.video.component.VideoReader;
import com.cocovo.fitqaspringjava.domain.video.entity.VideoFeedbackWaiting;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VideoReaderImpl implements VideoReader {

    private final VideoFeedbackWaitingRepository videoFeedbackWaitingRepository;

    @Override
    public VideoFeedbackWaiting findWaitingByVideoKey(String videoKey) {
        return videoFeedbackWaitingRepository.findByVideoKey(videoKey)
                .orElseThrow(VideoNotRegisteredException::new);
    }
}
