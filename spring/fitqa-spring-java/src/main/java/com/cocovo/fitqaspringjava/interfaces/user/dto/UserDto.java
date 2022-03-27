package com.cocovo.fitqaspringjava.interfaces.user.dto;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public class UserDto {

  @Getter
  @ToString
  public static class RegisterRequest {
    @NotBlank(message = "nickName 은 필수값입니다")
    private String nickName;
    @NotNull(message = "birthDay 는 필수값입니다")
    private ZonedDateTime birthDay;
    @NotNull(message = "workOutLevel 은 필수값입니다")
    private UserSpec.WorkOutLevel workOutLevel;
    @NotNull(message = "height 는 필수값입니다")
    private Integer height;
    @NotNull(message = "weight 는 필수값입니다")
    private Integer weight;
    @NotNull(message = "gender 는 필수값입니다")
    private User.Gender gender;


    private WorkOutType.Style workOutStyle;
    private Float bodyFatPercentage;
    private Float muscleMass;
  }

  @Getter
  @Builder
  @ToString
  public static class RegisterResponse {
    private final String userToken;
  }
}
