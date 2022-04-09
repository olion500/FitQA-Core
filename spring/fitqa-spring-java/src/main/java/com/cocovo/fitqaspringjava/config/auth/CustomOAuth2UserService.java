package com.cocovo.fitqaspringjava.config.auth;

import com.cocovo.fitqaspringjava.application.user.UserFacade;
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

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var delegate = new DefaultOAuth2UserService();
        var oAuth2User = delegate.loadUser(userRequest);

        // OAuth2 Service id (ex. google, kakao, naver)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        // OAuth2 로그인 진행 시 키가 되는 필드 값(PK)
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        // Call UserFacade to save user data.
        var initUser = UserDto.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        var userUpdateCommand = userDtoMapper.of(initUser);
        var userInfo = userFacade.saveOrUpdate(userUpdateCommand);
        var user = userDtoMapper.of(userInfo);

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("USER")), initUser.getAttributes(user.getUserToken()), initUser.getAttributeKey());
    }
}
