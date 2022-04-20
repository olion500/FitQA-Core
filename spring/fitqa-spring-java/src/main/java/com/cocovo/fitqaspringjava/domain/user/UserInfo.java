package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.user.User.Gender;
import com.cocovo.fitqaspringjava.domain.user.User.WorkOutLevel;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class UserInfo {

  @Getter
  @Builder
  @ToString
  public static class Main {

    private String userToken;
    private String email;
    private String name;
    private String photoURL;
    private WorkOutType.Style workOutStyle;
    private WorkOutLevel workOutLevel;
    private Gender gender;
    private User.AccountProvider provider;
  }

  @Getter
  @Builder
  @ToString
  public static class Info {

    private String userToken;
    private String email;
    private String name;
    private String photoURL;
    private ZonedDateTime birthDay;
    private Integer height;
    private Integer weight;
    private Double bodyPatPercentage;
    private Double muscleMass;
    private WorkOutType.Style workOutStyle;
    private WorkOutLevel workOutLevel;
    private Gender gender;
    private User.AccountProvider provider;
  }
}
