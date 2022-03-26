package com.cocovo.fitqaspringjava.domain.user.entity;

import com.google.common.collect.Lists;
import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
  private static final String PREFIX_USER = "usr_";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userToken;
  private String nickName;
  private ZonedDateTime birthDay;
  private Integer age;
  private Integer height;
  private Integer weight;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Getter
  @RequiredArgsConstructor
  public enum Gender {
    FEMALE("여성"), MALE("남성");

    private final String description;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.PERSIST)
  private List<UserImage> imageList = Lists.newArrayList();

  @Builder
  public User(String nickName, ZonedDateTime birthDay, Integer age, Integer height, Integer weight,
              Gender gender) {
    //Todo(in.heo): Need to improve exception
    if (StringUtils.isEmpty(nickName))
      throw new InvalidParamException("empty PartnerName");

    this.userToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_USER);
    this.nickName = nickName;
    this.birthDay = birthDay;

    // Todo(in.heo): Need to remove age argument and using birthDay
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.gender = gender;
  }
}
