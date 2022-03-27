package com.cocovo.fitqaspringjava.interfaces.user.controller;

import com.cocovo.fitqaspringjava.application.user.UserFacade;
import com.cocovo.fitqaspringjava.common.response.CommonResponse;
import com.cocovo.fitqaspringjava.interfaces.user.dto.UserDto;
import com.cocovo.fitqaspringjava.interfaces.user.mapper.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserApiController {
  private final UserDtoMapper userDtoMapper;
  private final UserFacade userFacade;

  @PostMapping
  public CommonResponse registerUser(@RequestBody @Valid UserDto.RegisterRequest request) {
    var userRequest = userDtoMapper.toUserRequest(request);
    var userSpecRequest = userDtoMapper.toUserSpecRequest(request);

    var userToken = userFacade.registerUser(userRequest, userSpecRequest);
    var response = userDtoMapper.of(userToken);
    return CommonResponse.success(response);
  }
}