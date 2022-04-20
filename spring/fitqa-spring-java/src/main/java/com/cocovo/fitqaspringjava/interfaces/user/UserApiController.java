package com.cocovo.fitqaspringjava.interfaces.user;

import com.cocovo.fitqaspringjava.application.user.UserFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import com.cocovo.fitqaspringjava.common.response.ErrorCode;
import com.cocovo.fitqaspringjava.interfaces.feedback.FeedbackDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
  public CommonResponse<UserDto.Info> getUserByToken(@PathVariable("userToken") String userToken) {
    var userInfo = userFacade.retrieveUserInfo(userToken);
    var response = userDtoMapper.of(userInfo);
    return CommonResponse.success(response);
  }

  @PostMapping("/{userToken}/update")
  public CommonResponse<UserDto.Main> updateUserInfo(@PathVariable("userToken") String userToken, @RequestBody @Valid UserDto.UpdateInfoReq request) {
    var updateInfoCommand = userDtoMapper.of(request);
    var userInfo = userFacade.updateUserInfo(userToken, updateInfoCommand);
    var response = userDtoMapper.of(userInfo);
    return CommonResponse.success(response);
  }

  @GetMapping("/success")
  public CommonResponse authSuccess() {
    return CommonResponse.success("success");
  }

  @GetMapping("/failed")
  public CommonResponse authFailed() {
    return CommonResponse.fail(ErrorCode.USER_AUTH_FAILED);
  }
}
