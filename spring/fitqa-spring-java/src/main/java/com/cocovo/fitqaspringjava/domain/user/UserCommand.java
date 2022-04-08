package com.cocovo.fitqaspringjava.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserCommand {

    @Getter
    @Builder
    @ToString
    public static class UpdateUser {
        private String email;
        private String name;
        private String photoURL;
        private User.AccountProvider provider;

        public User toEntity() {
            return User.builder()
                    .email(email)
                    .name(name)
                    .photoURL(photoURL)
                    .build();
        }
    }
}
