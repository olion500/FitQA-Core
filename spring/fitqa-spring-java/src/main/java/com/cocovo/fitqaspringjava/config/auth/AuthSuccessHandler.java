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
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var userToken = getTokenFromPrincipal(authentication.getPrincipal());
        sendDirectToUserDetail(response, userToken);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
        var userToken = getTokenFromPrincipal(authentication.getPrincipal());
        sendDirectToUserDetail(response, userToken);
    }

    private void sendDirectToUserDetail(HttpServletResponse response, String userToken) throws IOException {
        var entryUrl = "/api/v1/users/" + userToken;
        response.sendRedirect(entryUrl);
    }

    private String getTokenFromPrincipal(Object principal) {
        return String.valueOf(((DefaultOAuth2User) principal).getAttributes().get("token"));
    }
}
