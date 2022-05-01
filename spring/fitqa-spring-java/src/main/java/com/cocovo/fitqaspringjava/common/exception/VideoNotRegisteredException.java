package com.cocovo.fitqaspringjava.common.exception;

import com.cocovo.fitqaspringjava.common.response.ErrorCode;

public class VideoNotRegisteredException extends BaseException {
  public VideoNotRegisteredException() {
    super(ErrorCode.VIDEO_NOT_REGISTERED);
  }

  public VideoNotRegisteredException(String message) {
    super(message, ErrorCode.VIDEO_NOT_REGISTERED);
  }
}
