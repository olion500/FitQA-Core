package com.cocovo.fitqaspringjava.domain.feedback.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
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
@Table(name = "feedbacks")
public class Feedback extends BaseEntity {
    private final String FEEDBACK_PREFIX = "fdb_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedbackToken;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private boolean locked;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PREPARE("답변대기"),
        COMPLETE("답변완료");

        private final String description;
    }

    @Builder
    public Feedback(String title, String content, boolean locked) {
        if (StringUtils.isEmpty(title)) throw new InvalidParamException("title cannot be empty.");
        if (StringUtils.isEmpty(content)) throw new InvalidParamException("content cannot be empty.");

        feedbackToken = TokenGenerator.randomCharacterWithPrefix(FEEDBACK_PREFIX);
        this.title = title;
        this.content = content;
        this.locked = locked;
        this.status = Status.PREPARE;
    }

    public void changeComplete() {
        this.status = Status.COMPLETE;
    }
}
