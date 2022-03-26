package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

public class UserCommand {
  /**
   * User Entity
   */
  @Getter
  @Builder
  @ToString
  public static class RegisterUserRequest {
    private final String nickName;
    private final ZonedDateTime birthDay;
    private final Integer age;
    private final Integer height;
    private final Integer weight;
    private final User.Gender gender;

    public User toEntity() {
      return User.builder().nickName(nickName).birthDay(birthDay).age(age).height(height)
          .weight(weight).gender(gender).build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class RegisterUserSpecRequest {
    private final UserSpec.WorkOutLevel workOutLevel;
    private final WorkOutType.Style workOutStyle;
    private final Float bodyFatPercentage;
    private final Float muscleMass;

    public UserSpec toEntity(String userToken) {
      return UserSpec.builder().userToken(userToken).workOutLevel(workOutLevel)
          .workOutStyle(workOutStyle).bodyFatPercentage(bodyFatPercentage).muscleMass(muscleMass)
          .build();
    }
  }

  /*
  @Getter
  @Builder
  @ToString
  public static class UpdateUserRequest {
    private final String nickName;
    private final ZonedDateTime birthDay;
    private final int age;
    private final int height;
    private final int weight;
    private final User.Gender gender;
  }
*/

  /**
   * User Spec Entity
   */
/*

  @Getter
  @Builder
  @ToString
  public static class UpdateUserSpecRequest {
    private final float bodyFatPercentage;
    private final float muscleMass;
    private final UserSpec.WorkOutStyle workOutStyle;
    private final UserSpec.WorkOutLevel workOutLevel;
  }
*/
  /**
   * User Spec Entity
   */
/*
  @Getter
  @Builder
  @ToString
  public static class RegisterUserImageRequest {
    private final String imageUrl;
    private final UserImage.ImageType imageType;
  }

  @Getter
  @Builder
  @ToString
  public static class GetUserImageRequest {
    private final UserImage.ImageType imageType;
  }

  @Getter
  @Builder
  @ToString
  public static class DeleteUserImageRequest {
    private final String userImageToken;
  }
*/
}
