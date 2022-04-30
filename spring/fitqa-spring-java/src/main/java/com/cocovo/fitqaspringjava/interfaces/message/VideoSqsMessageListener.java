package com.cocovo.fitqaspringjava.interfaces.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VideoSqsMessageListener {

    // TODO : change policy to ON_SUCCESS
    @SqsListener(value = "fitqa-video-complete", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void readMessage(VideoCompleteMessage message) {
        log.info(message.getKey());
    }
}
