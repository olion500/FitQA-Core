package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

public class UserInfo {

  @Getter
  @Builder
  @ToString
  public static class Main {
    private final String userToken;
    private final String nickName;
    private final ZonedDateTime birthDay;
    private final Integer age;
    private final Integer height;
    private final Integer weight;
    private final GenderInfo gender;
    private List<ImageInfo> images;
    private SpecInfo userSpec;
  }

  @Getter
  @Builder
  @ToString
  public static class ImageInfo {
    private final String imageUrl;
    private final TypeInfo.ImageType imageType;
  }

  @Getter
  @Builder
  @ToString
  public static class OauthInfo {
    private final String oauthProvider;
    private final String accessToken;
    private final String refreshToken;
    private final ZonedDateTime expiryDate;
  }

  @Getter
  @Builder
  @ToString
  public static class SpecInfo {
    private final Float bodyFatPercentage;
    private final Float muscleMass;
    private final TypeInfo.WorkOutStyle workOutStyle;
    private final WorkOutLevelInfo workOutLevel;
  }

  @Getter
  @RequiredArgsConstructor
  public enum GenderInfo {
    FEMALE("여성"), MALE("남성");

    private final String description;
  }

  @Getter
  @RequiredArgsConstructor
  public enum WorkOutLevelInfo {
    BEGINNER("초보자"), INTERMEDIATE("중급자"), ADVANCED("상급자"), SKILLED("숙련자");

    private final String description;
  }
}
