package com.cocovo.fitqaspringjava.domain.user.component;

import com.cocovo.fitqaspringjava.domain.feedback.entity.Feedback;
import com.cocovo.fitqaspringjava.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserReader {

  List<User> retrieveUserAll();

  User retrieveUserByToken(String userToken);

  User findByEmail(String email);
}
