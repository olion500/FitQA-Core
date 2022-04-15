package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType;
import com.cocovo.fitqaspringjava.domain.common.entity.type.WorkOutType.Style;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

  private static final String USER_PREFIX = "usr_";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userToken;

  private String email;
  private String name;
  private String photoURL;
  private ZonedDateTime birthDay;

  private Integer height;
  private Integer weight;

  private Double bodyPatPercentage;
  private Double muscleMass;

  @Enumerated(EnumType.STRING)
  private WorkOutType.Style workOutStyle;

  @Enumerated(EnumType.STRING)
  private WorkOutLevel workOutLevel;

  @RequiredArgsConstructor
  public enum WorkOutLevel {
    BEGINNER("초보자"),
    INTERMEDIATE("중급자"),
    SENIOR("상급자"),
    SUPER("초고수");

    private final String description;
  }

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @RequiredArgsConstructor
  public enum Gender {
    FEMALE("여성"),
    MALE("남성");

    private final String description;
  }


  @Enumerated(EnumType.STRING)
  private AccountProvider provider;

  @Getter
  @RequiredArgsConstructor
  public enum AccountProvider {
    GOOGLE("google"),
    NAVER("naver"),
    KAKAO("kakao");

    private final String provider;
  }

  @Builder
  public User(String email, String name, String photoURL, ZonedDateTime birthDay,
      Integer height, Integer weight, Double bodyPatPercentage, Double muscleMass,
      Style workOutStyle,
      WorkOutLevel workOutLevel, Gender gender,
      AccountProvider provider) {
    if (StringUtils.isEmpty(name)) {
      throw new InvalidParamException("name cannot be empty");
    }
    if (StringUtils.isEmpty(email)) {
      throw new InvalidParamException("name cannot be empty");
    }
    this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_PREFIX);
    this.email = email;
    this.name = name;
    this.photoURL = photoURL;
    this.birthDay = birthDay;
    this.height = height;
    this.weight = weight;
    this.bodyPatPercentage = bodyPatPercentage;
    this.muscleMass = muscleMass;
    this.workOutStyle = workOutStyle;
    this.workOutLevel = workOutLevel;
    this.gender = gender;
    this.provider = provider;
  }

  public User update(String name, String photoUrl) {
    this.name = name;
    this.photoURL = photoUrl;
    return this;
  }
}
