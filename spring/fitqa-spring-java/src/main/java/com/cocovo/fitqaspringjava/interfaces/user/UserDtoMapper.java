package com.cocovo.fitqaspringjava.interfaces.user;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserDtoMapper {
    UserDto.Main of(UserInfo.Main userInfo);

    UserCommand.UpdateUser of(UserDto.RegisterReq user);
}
