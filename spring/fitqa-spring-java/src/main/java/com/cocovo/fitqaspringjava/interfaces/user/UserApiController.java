package com.cocovo.fitqaspringjava.interfaces.user;

import com.cocovo.fitqaspringjava.application.user.UserFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import com.cocovo.fitqaspringjava.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserApiController {

  private final UserFacade userFacade;
  private final UserDtoMapper userDtoMapper;

  @GetMapping
  public CommonResponse<List<UserDto.Main>> getUserAll() {
    var users = userFacade.retrieveUsers();
    var response = users.stream()
        .map(userDtoMapper::of)
        .collect(Collectors.toList());
    return CommonResponse.success(response);
  }

  @GetMapping("/{userToken}")
  public CommonResponse<UserDto.Main> getUserByToken(@PathVariable("userToken") String userToken) {
    var userInfo = userFacade.retrieveUserInfo(userToken);
    var response = userDtoMapper.of(userInfo);
    return CommonResponse.success(response);
  }

  @GetMapping("/failed")
  public CommonResponse authFailed() {
    return CommonResponse.fail(ErrorCode.USER_AUTH_FAILED);
  }
}
