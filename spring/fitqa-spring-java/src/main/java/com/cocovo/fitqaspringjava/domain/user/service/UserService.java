package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;

public interface UserService {
  String registerUser(UserCommand.RegisterUser registerUser);
}
