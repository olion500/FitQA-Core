package com.cocovo.fitqaspringjava.domain.user.mapper;

import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import com.cocovo.fitqaspringjava.domain.user.entity.User;
import com.cocovo.fitqaspringjava.domain.user.entity.UserImage;
import com.cocovo.fitqaspringjava.domain.user.entity.UserOauth;
import com.cocovo.fitqaspringjava.domain.user.entity.UserSpec;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserInfoMapper {
  UserInfo.Main of(User user);

  UserInfo.ImageInfo of(UserImage userImage);

  UserInfo.OauthInfo of(UserOauth userOauth);

  UserInfo.SpecInfo of(UserSpec userSpec);
}
