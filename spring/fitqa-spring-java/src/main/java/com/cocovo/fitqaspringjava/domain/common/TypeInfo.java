package com.cocovo.fitqaspringjava.domain.common;

import lombok.RequiredArgsConstructor;

public class TypeInfo {

  @RequiredArgsConstructor
  public enum ImageType {
    BACKGROUND("배경"), GALLERY("갤러리"), PROFILE("프로필");

    private final String description;
  }

  @RequiredArgsConstructor
  public enum SnsType {
    FACEBOOK("페이스북"), INSTAGRAM("인스타그램"), YOUTUBE("유튜브");

    private final String description;
  }

  @RequiredArgsConstructor
  public enum WorkOutStyle {
    NONE("미등록"), BODY_BUILDING("보디빌딩"), DIET("다이어트");

    private final String description;
  }

  @RequiredArgsConstructor
  public enum InterestArea {
    LOWER("하체"), BACK("등"), CHEST("가슴"), SHOULDER("어깨");

    private final String description;
  }
}
