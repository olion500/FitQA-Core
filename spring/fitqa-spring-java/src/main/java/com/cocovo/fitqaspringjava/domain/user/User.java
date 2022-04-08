package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
    private final String USER_PREFIX = "usr_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userToken;

    private String email;
    private String name;
    private String photoURL;

    @Enumerated(EnumType.STRING)
    private AccountProvider provider;

    @Getter
    @RequiredArgsConstructor
    public enum AccountProvider {
        GOOGLE("google"),
        NAVER("naver"),
        KAKAO("kakao");

        private final String provider;
    }

    @Builder
    public User(String email, String name, String photoURL, AccountProvider provider) {
        this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_PREFIX);
        this.email = email;
        this.name = name;
        this.photoURL = photoURL;
        this.provider = provider;
    }

    public User update(String name, String photoUrl) {
        this.name = name;
        this.photoURL = photoUrl;
        return this;
    }
}
