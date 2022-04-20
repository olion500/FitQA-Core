package com.cocovo.fitqaspringjava.common.exception;

import com.cocovo.fitqaspringjava.common.response.ErrorCode;

public class FeedbackAnswerException extends BaseException {

  public FeedbackAnswerException() {
    super(ErrorCode.FEEDBACK_ANSWER_FAILED);
  }

  public FeedbackAnswerException(String message) {
    super(message, ErrorCode.FEEDBACK_ANSWER_FAILED);
  }
}
