package com.cocovo.fitqaspringjava.domain.user;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class UserInfo implements Serializable {
    private String email;
    private String name;
    private String photoURL;

    public static UserInfo of(User user) {
        return UserInfo.builder()
                .email(user.getEmail())
                .name(user.getName())
                .photoURL(user.getPhotoUrl())
                .build();
    }
}
