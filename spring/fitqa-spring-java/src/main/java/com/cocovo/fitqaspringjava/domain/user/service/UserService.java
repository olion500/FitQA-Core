package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;

import java.util.List;

public interface UserService {

  List<UserInfo.Main> retrieveUsers();

  UserInfo.Info retrieveUserByToken(String userToken);

  UserInfo.Main saveOrUpdate(UserCommand.UpdateUser command);

  UserInfo.Main updateUserInfo(String userToken, UserCommand.UpdateUserInfo command);
}
