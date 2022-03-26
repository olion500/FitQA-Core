package com.cocovo.fitqaspringjava.common.exception;

import com.cocovo.fitqaspringjava.common.response.ErrorCode;

public class InvalidParamException extends BaseException {
  public InvalidParamException() {
    super(ErrorCode.COMMON_INVALID_PARAMETER);
  }

  public InvalidParamException(String message) {
    super(message, ErrorCode.COMMON_INVALID_PARAMETER);
  }
}
