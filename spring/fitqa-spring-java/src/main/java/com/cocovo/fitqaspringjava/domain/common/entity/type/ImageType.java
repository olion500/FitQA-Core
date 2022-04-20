package com.cocovo.fitqaspringjava.domain.common.entity.type;

import lombok.RequiredArgsConstructor;

public class ImageType {

  @RequiredArgsConstructor
  public enum Type {
    BACKGROUND("배경"), GALLERY("갤러리"), PROFILE("프로필");

    private final String description;
  }
}
