package com.cocovo.fitqaspringjava.config.auth;

import com.cocovo.fitqaspringjava.application.trainer.TrainerFacade;
import com.cocovo.fitqaspringjava.application.user.UserFacade;
import com.cocovo.fitqaspringjava.common.exception.EntityNotFoundException;
import com.cocovo.fitqaspringjava.domain.trainer.TrainerInfo;
import com.cocovo.fitqaspringjava.domain.user.User;
import com.cocovo.fitqaspringjava.interfaces.user.UserDto;
import com.cocovo.fitqaspringjava.interfaces.user.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

  private final UserDtoMapper userDtoMapper;
  private final UserFacade userFacade;
  private final TrainerFacade trainerFacade;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    var delegate = new DefaultOAuth2UserService();
    var oAuth2User = delegate.loadUser(userRequest);

    // OAuth2 Service id (ex. google, kakao, naver)
    String registrationId = userRequest.getClientRegistration().getRegistrationId();
    // OAuth2 로그인 진행 시 키가 되는 필드 값(PK)
    String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
        .getUserInfoEndpoint().getUserNameAttributeName();

    // 0. 로그인한 사용자의 정보를 가져온다.
    var oauthUser = UserDto.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

    // 1. user 에 없으면 등록을 하고 키를 받아온다.
    var user = saveOrUpdateUser(oauthUser);

    // 2. trainer 에 해당 이메일이 있으면 그 정보를 가져온다.
    TrainerInfo.Main trainer;
    try {
      trainer = trainerFacade.retrieveTrainerInfoByEmail(oauthUser.getEmail());
    } catch (EntityNotFoundException e) {
      trainer = null;
    }

    // 3. trainer 이면 trainer Token 을, 아니면 user token 을 반환한다.
    var token = (trainer == null) ? user.getUserToken() : trainer.getTrainerToken();

    return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("USER")),
        oauthUser.getAttributes(token), oauthUser.getAttributeKey());
  }

  private UserDto.Main saveOrUpdateUser(UserDto.RegisterReq initUser) {
    var userUpdateCommand = userDtoMapper.of(initUser);
    var userInfo = userFacade.saveOrUpdate(userUpdateCommand);
    return userDtoMapper.of(userInfo);
  }
}
