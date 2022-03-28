package com.cocovo.fitqaspringjava.application.user;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {
  private final UserService userService;

  public String registerUser(UserCommand.RegisterUser registerUser) {
    var userToken = userService.registerUser(registerUser);
    return userToken;
  }
}
