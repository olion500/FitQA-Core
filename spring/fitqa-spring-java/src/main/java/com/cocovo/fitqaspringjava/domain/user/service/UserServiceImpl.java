package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.component.UserStore;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserStore userStore;

  @Override
  @Transactional
  public String registerUser(UserCommand.RegisterUserRequest user_request,
                             UserCommand.RegisterUserSpecRequest user_spec_request) {
    User initUser = user_request.toEntity();
    User registeredUser = userStore.store(initUser);

    UserSpec initUserSpec = user_spec_request.toEntity(registeredUser.getUserToken());
    userStore.store(initUserSpec);

    return registeredUser.getUserToken();
  }
}
