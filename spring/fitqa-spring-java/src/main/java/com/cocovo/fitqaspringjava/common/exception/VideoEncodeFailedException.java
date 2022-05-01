package com.cocovo.fitqaspringjava.common.exception;

import com.cocovo.fitqaspringjava.common.response.ErrorCode;

public class VideoEncodeFailedException extends BaseException{
  public VideoEncodeFailedException() {
    super(ErrorCode.VIDEO_ENCODE_FAILED);
  }

  public VideoEncodeFailedException(String message) {
    super(message, ErrorCode.VIDEO_ENCODE_FAILED);
  }

}
