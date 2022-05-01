package com.cocovo.fitqaspringjava.domain.video.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "video_feedback_waitings")
public class VideoFeedbackWaiting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feedbackToken;
    private String videoKey;
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        WAITING("대기중"),
        DONE("완료");

        private final String description;
    }

    @Builder
    public VideoFeedbackWaiting(String feedbackToken, String videoKey) {
        if (StringUtils.isEmpty(feedbackToken))
            throw new InvalidParamException("feedback token cannot be empty");
        if (StringUtils.isEmpty(videoKey))
            throw new InvalidParamException("videoKey cannot be empty");

        this.feedbackToken = feedbackToken;
        this.videoKey = videoKey;
        this.status = Status.WAITING;
    }

    public void changeDone() {
        this.status = Status.DONE;
    }
}
