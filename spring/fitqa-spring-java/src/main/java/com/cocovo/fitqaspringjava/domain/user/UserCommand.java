package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

public class UserCommand {

  @Getter
  @Builder
  @ToString
  public static class UpdateUser {

    private String email;
    private String name;
    private String photoURL;
    private User.AccountProvider provider;

    public User toEntity() {
      return User.builder()
          .email(email)
          .name(name)
          .photoURL(photoURL)
          .provider(provider)
          .build();
    }
  }

  @Getter
  @Builder
  @ToString
  public static class UpdateUserInfo {
    private String name;
    private ZonedDateTime birthDay;
    private Integer height;
    private Integer weight;
    private double bodyPatPercentage;
    private double muscleMass;
    private WorkOutType.Style workOutStyle;
    private User.WorkOutLevel workOutLevel;
  }
}
