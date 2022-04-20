package com.cocovo.fitqaspringjava.interfaces.user;

import com.cocovo.fitqaspringjava.domain.user.UserCommand;
import com.cocovo.fitqaspringjava.domain.user.UserInfo;
import org.mapstruct.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserDtoMapper {

  UserDto.Main of(UserInfo.Main userInfo);
  UserDto.Info of(UserInfo.Info userInfo);

  UserCommand.UpdateUser of(UserDto.RegisterReq user);

  @Mapping(source = "birthDay", target = "birthDay", qualifiedByName = "fromStringToZonedDatetime")
  UserCommand.UpdateUserInfo of(UserDto.UpdateInfoReq req);

  @Named("fromStringToZonedDatetime")
  default ZonedDateTime fromStringToZonedDatetime(String dateString) {
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
    try {
      Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
      LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();

      zonedDateTime = zonedDateTime.withYear(localDate.getYear())
              .withMonth(localDate.getMonth().getValue())
              .withDayOfMonth(localDate.getDayOfMonth());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return zonedDateTime;
  }
}
