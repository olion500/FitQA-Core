package com.cocovo.fitqaspringjava.domain.feedback.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "feedback_answer")
public class FeedbackAnswer extends BaseEntity {
  private final String FEEDBACK_ANSWER_PREFIX = "fas_";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String feedbackAnswerToken;

  @OneToOne
  @JoinColumn(name = "feedback_id")
  private Feedback feedback;

  private String videoUrl;
  private String description;

  @Builder
  public FeedbackAnswer(Feedback feedback, String videoUrl, String description) {
    if (feedback == null) throw new InvalidParamException("feedback cannot be null");
    if (StringUtils.isEmpty(videoUrl)) throw new InvalidParamException("videoUrl cannot be empty.");
    if (StringUtils.isEmpty(description)) throw new InvalidParamException("description cannot be empty.");

    this.feedbackAnswerToken = TokenGenerator.randomCharacterWithPrefix(FEEDBACK_ANSWER_PREFIX);
    this.feedback = feedback;
    this.videoUrl = videoUrl;
    this.description = description;
  }
}