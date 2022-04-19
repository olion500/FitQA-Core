package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.common.exception.EntityNotFoundException;
import com.cocovo.fitqaspringjava.domain.user.User;
import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import com.cocovo.fitqaspringjava.domain.user.component.UserInfoMapper;
import com.cocovo.fitqaspringjava.domain.user.component.UserReader;
import com.cocovo.fitqaspringjava.domain.user.component.UserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserInfoMapper userInfoMapper;

  private final UserReader userReader;
  private final UserStore userStore;

  @Override
  @Transactional(readOnly = true)
  public List<UserInfo.Main> retrieveUsers() {
    var users = userReader.retrieveUserAll();
    return users.stream()
        .map(userInfoMapper::of)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public UserInfo.Main retrieveUserByToken(String userToken) {
    var user = userReader.retrieveUserByToken(userToken);
    return userInfoMapper.of(user);
  }

  @Override
  @Transactional
  public UserInfo.Main saveOrUpdate(UserCommand.UpdateUser command) {
    User user;
    try {
      user = userReader.findByEmail(command.getEmail());
      user.update(command.getName(), command.getPhotoURL());
    } catch (EntityNotFoundException e) {
      var initUser = command.toEntity();
      user = userStore.store(initUser);
    }
    return userInfoMapper.of(user);
  }
}
