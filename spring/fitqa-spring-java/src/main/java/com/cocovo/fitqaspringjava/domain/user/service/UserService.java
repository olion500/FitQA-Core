package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;

import java.util.List;

public interface UserService {

  List<UserInfo.Main> retrieveUsers();

  UserInfo.Main retrieveUserByToken(String userToken);

  UserInfo.Main saveOrUpdate(UserCommand.UpdateUser command);
}
