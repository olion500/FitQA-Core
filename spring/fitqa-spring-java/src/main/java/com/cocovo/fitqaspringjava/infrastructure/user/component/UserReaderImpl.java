package com.cocovo.fitqaspringjava.infrastructure.user.component;

import com.cocovo.fitqaspringjava.common.exception.EntityNotFoundException;
import com.cocovo.fitqaspringjava.domain.user.User;
import com.cocovo.fitqaspringjava.domain.user.component.UserReader;
import com.cocovo.fitqaspringjava.infrastructure.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

  private final UserRepository userRepository;

  @Override
  public List<User> retrieveUserAll() {
    return userRepository.findAll();
  }

  @Override
  public User retrieveUserByToken(String userToken) {
    return userRepository.findByUserToken(userToken)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(EntityNotFoundException::new);
  }
}
