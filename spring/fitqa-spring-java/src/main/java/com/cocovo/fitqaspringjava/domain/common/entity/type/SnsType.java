package com.cocovo.fitqaspringjava.domain.common.entity.type;

import lombok.RequiredArgsConstructor;

public class SnsType {
  @RequiredArgsConstructor
  public enum Type {
    FACEBOOK("페이스북"), INSTAGRAM("인스타그램"), YOUTUBE("유튜브");

    private final String description;
  }
}
