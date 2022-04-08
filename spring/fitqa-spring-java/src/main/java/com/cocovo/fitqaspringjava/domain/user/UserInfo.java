package com.cocovo.fitqaspringjava.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class UserInfo {

    @Getter
    @Builder
    @ToString
    public static class Main{
        private String userToken;
        private String email;
        private String name;
        private String photoURL;
        private User.AccountProvider provider;
    }

}
