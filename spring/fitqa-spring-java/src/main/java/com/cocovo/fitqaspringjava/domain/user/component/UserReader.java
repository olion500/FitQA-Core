package com.cocovo.fitqaspringjava.domain.user.component;

import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import com.cocovo.fitqaspringjava.domain.user.entity.User;

import java.util.List;

public interface UserReader {
  User getUserBy(String userToken);
  List<User> findUserAllBy(List<String> userToken);
  List<UserInfo.Image> getUserImages(String userToken);
}
