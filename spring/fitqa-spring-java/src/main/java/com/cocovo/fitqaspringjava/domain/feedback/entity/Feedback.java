package com.cocovo.fitqaspringjava.domain.feedback.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "feedbacks")
public class Feedback extends BaseEntity {
    private static final String FEEDBACK_PREFIX = "fdb_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedbackToken;

    private String ownerId;
    private Long trainerId;
    @Enumerated(EnumType.STRING)
    private TypeInfo.InterestArea interestArea;
    private Integer price;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private boolean locked;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "feedback", cascade = CascadeType.PERSIST)
    private List<FeedbackComment> feedbackCommentList = Lists.newArrayList();

    @OneToOne(mappedBy = "feedback", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private FeedbackAnswer feedbackAnswer;

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
    public Feedback(String ownerId, Long trainerId, TypeInfo.InterestArea interestArea,
                    Integer price, String title, String content, boolean locked) {
        if (StringUtils.isEmpty(ownerId)) throw new InvalidParamException("ownerId cannot be empty.");
        if (price < 0) throw new InvalidParamException("price cannot be below 0");
        if (StringUtils.isEmpty(title)) throw new InvalidParamException("title cannot be empty.");
        if (StringUtils.isEmpty(content)) throw new InvalidParamException("content cannot be empty.");


        this.feedbackToken = TokenGenerator.randomCharacterWithPrefix(FEEDBACK_PREFIX);
        this.ownerId = ownerId;
        this.trainerId = trainerId;
        this.interestArea = interestArea;
        this.price = price;
        this.title = title;
        this.content = content;
        this.locked = locked;
        this.status = Status.PREPARE;
    }

    public void changeComplete() {
        this.status = Status.COMPLETE;
    }
}
