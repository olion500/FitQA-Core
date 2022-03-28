package com.cocovo.fitqaspringjava.domain.user.mapper;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
  User of(UserCommand.RegisterUser registerUser);

  @Mapping(source = "registerUser.workOutLevel", target = "workOutLevel")
  @Mapping(source = "registerUser.workOutStyle", target = "workOutStyle")
  @Mapping(source = "registerUser.bodyFatPercentage", target = "bodyFatPercentage")
  @Mapping(source = "registerUser.muscleMass", target = "muscleMass")
  @Mapping(source = "user", target = "user")
  UserSpec specOf(User user, UserCommand.RegisterUser registerUser);
}
