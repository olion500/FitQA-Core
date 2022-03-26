package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.domain.common.entity.type.ImageType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

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
    private final User.Gender gender;
  }

  @Getter
  @Builder
  @ToString
  public static class Image {
    private final String imageUrl;
    private final ImageType.Type imageType;
  }

  @Getter
  @Builder
  @ToString
  public static class Oauth {
    private final String oauthProvider;
    private final String accessToken;
    private final String refreshToken;
    private final ZonedDateTime expiryDate;
  }

  @Getter
  @Builder
  @ToString
  public static class Spec {
    private final Float bodyFatPercentage;
    private final Float muscleMass;
    private final WorkOutType.Style workOutStyle;
    private final UserSpec.WorkOutLevel workOutLevel;
  }
}
