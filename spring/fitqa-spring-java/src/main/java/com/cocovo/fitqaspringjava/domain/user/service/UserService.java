package com.cocovo.fitqaspringjava.domain.user.service;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;

public interface UserService {
  String registerUser(UserCommand.RegisterUserRequest user_request,
                      UserCommand.RegisterUserSpecRequest user_spec_request);
}
