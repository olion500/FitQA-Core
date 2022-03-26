package com.cocovo.fitqaspringjava.domain.user.component;

import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;

public interface UserStore {
  User store(User initUser);
  UserSpec store(UserSpec initUserSpec);
}
