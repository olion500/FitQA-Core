package com.cocovo.fitqaspringjava.domain.user.component;

import com.cocovo.fitqaspringjava.domain.user.User;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserInfoMapper {

  UserInfo.Main of(User user);
  UserInfo.Info ofInfo(User user);
}
