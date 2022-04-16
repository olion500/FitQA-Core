package com.cocovo.fitqaspringjava.domain.common.entity.type;

import lombok.RequiredArgsConstructor;

public class WorkOutType {

  @RequiredArgsConstructor
  public enum Style {
    NONE("미등록"), BODY_BUILDING("보디빌딩"), DIET("다이어트");

    private final String description;
  }

  @RequiredArgsConstructor
  public enum InterestArea {
    LOWER("하체"), BACK("등"), CHEST("가슴"), SHOULDER("어깨"), ARM("팔");

    private final String description;
  }
}
