package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.component.UserStore;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import com.cocovo.fitqaspringjava.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserStore userStore;
  private final UserMapper userMapper;

  @Override
  @Transactional
  public String registerUser(UserCommand.RegisterUser registerUser) {
    User initUser = userMapper.of(registerUser);
    User registeredUser = userStore.store(initUser);

    UserSpec initUserSpec = userMapper.specOf(registeredUser, registerUser);
    userStore.store(initUserSpec);

    return registeredUser.getUserToken();
  }
}
