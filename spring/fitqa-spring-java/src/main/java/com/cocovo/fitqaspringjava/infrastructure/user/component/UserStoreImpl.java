package com.cocovo.fitqaspringjava.infrastructure.user.component;

import com.cocovo.fitqaspringjava.domain.user.component.UserStore;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import com.cocovo.fitqaspringjava.infrastructure.user.repository.UserRepository;
import com.cocovo.fitqaspringjava.infrastructure.user.repository.UserSpecRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
  private final UserRepository userRepository;
  private final UserSpecRepository userSpecRepository;

  @Override
  public User store(User initUser) {
    return userRepository.save(initUser);
  }

  @Override
  public UserSpec store(UserSpec initUserSpec) {
    return userSpecRepository.save(initUserSpec);
  }
}
