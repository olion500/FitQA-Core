package com.cocovo.fitqaspringjava.config;

import com.cocovo.fitqaspringjava.config.auth.AuthFailureHandler;
import com.cocovo.fitqaspringjava.config.auth.AuthSuccessHandler;
import com.cocovo.fitqaspringjava.config.auth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // Spring Security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomOAuth2UserService customOauth2UserService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .formLogin().disable()
        .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션 disable
        .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
        .oauth2Login()
        .userInfoEndpoint()
        .userService(customOauth2UserService)
        .and()
        .successHandler(new AuthSuccessHandler())
        .failureHandler(new AuthFailureHandler())
    ;
  }
}
