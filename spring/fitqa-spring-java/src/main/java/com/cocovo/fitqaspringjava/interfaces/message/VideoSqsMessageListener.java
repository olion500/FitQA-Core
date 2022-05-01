package com.cocovo.fitqaspringjava.interfaces.message;

import com.cocovo.fitqaspringjava.application.video.VideoFacade;
import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.video.VideoCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VideoSqsMessageListener {

    private final VideoFacade videoFacade;

    @SqsListener(value = "fitqa-video-complete", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void readVideoCompleteMessage(VideoCompleteMessage message) {
        log.info(message.getKey());

        var video = getFile(message, VideoCompleteMessage.FileType.VIDEO);
        var thumbnail = getFile(message, VideoCompleteMessage.FileType.IMAGE);
        var registerCommand = VideoCommand.Register
                .builder()
                .videoKey(message.getKey())
                .videoUrl(video.getUrl())
                .thumbnailUrl(thumbnail.getUrl())
                .height(video.getHeight())
                .width(video.getWidth())
                .build();

        videoFacade.registerVideo(message.getKey(), registerCommand);
    }

    private VideoCompleteMessage.VideoCompleteFile getFile(VideoCompleteMessage message, VideoCompleteMessage.FileType fileType) {
        return message.getFiles().stream().filter(f -> f.getType() == fileType).findFirst()
                .orElseThrow(InvalidParamException::new);
    }
}
