package com.cocovo.fitqaspringjava.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    var userToken = getValueFromPrincipal(authentication.getPrincipal(), "token");
    var trainerToken = getValueFromPrincipal(authentication.getPrincipal(), "trainer_token");
    sendDirectToUserDetail(response, userToken, trainerToken);
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authentication) throws IOException, ServletException {
    AuthenticationSuccessHandler.super
        .onAuthenticationSuccess(request, response, chain, authentication);
    var userToken = getValueFromPrincipal(authentication.getPrincipal(), "token");
    var trainerToken = getValueFromPrincipal(authentication.getPrincipal(), "trainer_token");
    sendDirectToUserDetail(response, userToken, trainerToken);
  }

  private void sendDirectToUserDetail(HttpServletResponse response, String userToken, String trainerToken)
      throws IOException {
    var entryUrl = "/api/v1/users/success?token=" + userToken + "&trainer_token=" + trainerToken;
    response.sendRedirect(entryUrl);
  }

  private String getValueFromPrincipal(Object principal, String key) {
    return String.valueOf(((DefaultOAuth2User) principal).getAttributes().get(key));
  }
}
