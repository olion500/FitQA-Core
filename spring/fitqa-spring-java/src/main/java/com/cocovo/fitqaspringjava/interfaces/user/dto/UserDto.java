package com.cocovo.fitqaspringjava.interfaces.user.dto;

import com.cocovo.fitqaspringjava.domain.common.TypeInfo;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public class UserDto {

  @Getter
  @ToString
  public static class RegisterUserRequest {
    @NotBlank(message = "nickName 은 필수값입니다")
    private String nickName;
    @NotNull(message = "birthDay 는 필수값입니다")
    private ZonedDateTime birthDay;
    @NotNull(message = "workOutLevel 은 필수값입니다")
    private UserInfo.WorkOutLevelInfo workOutLevel;
    @NotNull(message = "height 는 필수값입니다")
    private Integer height;
    @NotNull(message = "weight 는 필수값입니다")
    private Integer weight;
    @NotNull(message = "gender 는 필수값입니다")
    private UserInfo.GenderInfo gender;


    private TypeInfo.WorkOutStyle workOutStyle;
    private Float bodyFatPercentage;
    private Float muscleMass;
  }

  @Getter
  @Builder
  @ToString
  public static class RegisterUserResponse {
    private final String userToken;
  }
}
