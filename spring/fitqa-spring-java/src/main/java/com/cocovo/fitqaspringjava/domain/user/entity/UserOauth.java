package com.cocovo.fitqaspringjava.domain.user.entity;

import com.cocovo.fitqaspringjava.common.exception.InvalidParamException;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users_oauth")
public class UserOauth extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private String oauthProvider;
  private String accessToken;
  private String refreshToken;

  private ZonedDateTime expiryDate;

  @Builder
  public UserOauth(Long userId, String oauthProvider, String accessToken, String refreshToken,
                   ZonedDateTime expiryDate) {
    //Todo(in.heo): Need to improve exception
    if (StringUtils.isEmpty(oauthProvider))
      throw new InvalidParamException("oauthProvider is empty");
    if (StringUtils.isEmpty(accessToken))
      throw new InvalidParamException("accessToken is empty");
    if (StringUtils.isEmpty(refreshToken))
      throw new InvalidParamException("refreshToken is empty");
    if (expiryDate.isBefore(ZonedDateTime.now()))
      throw new InvalidParamException("expiryDate is over");

    this.userId = userId;
    this.oauthProvider = oauthProvider;
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
    this.expiryDate = expiryDate;
  }
}
