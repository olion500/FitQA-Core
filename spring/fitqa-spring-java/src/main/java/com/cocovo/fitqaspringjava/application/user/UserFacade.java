package com.cocovo.fitqaspringjava.application.user;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import com.cocovo.fitqaspringjava.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public List<UserInfo.Main> retrieveUsers() {
        return userService.retrieveUsers();
    }

    public UserInfo.Main retrieveUserInfo(String userToken) {
        return userService.retrieveUserByToken(userToken);
    }

    public UserInfo.Main saveOrUpdate(UserCommand.UpdateUser command) {
        return userService.saveOrUpdate(command);
    }
}
