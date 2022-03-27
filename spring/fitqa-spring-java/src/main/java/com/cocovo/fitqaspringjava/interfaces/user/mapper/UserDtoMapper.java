package com.cocovo.fitqaspringjava.interfaces.user.mapper;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.interfaces.user.dto.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)

public interface UserDtoMapper {
  @Mapping(target = "age", ignore = true)
  UserCommand.RegisterUserRequest toUserRequest(UserDto.RegisterUserRequest request);

  UserCommand.RegisterUserSpecRequest toUserSpecRequest(UserDto.RegisterUserRequest request);

  UserDto.RegisterUserResponse of(String userToken);
}
