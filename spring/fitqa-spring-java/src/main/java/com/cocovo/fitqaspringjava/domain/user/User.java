package com.cocovo.fitqaspringjava.domain.user;

import com.cocovo.fitqaspringjava.common.util.TokenGenerator;
import com.cocovo.fitqaspringjava.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String photoUrl;

    public User(String email, String name, String photoUrl) {
        this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_PREFIX);
        this.email = email;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public User update(String name, String photoUrl) {
        this.name = name;
        this.photoUrl = photoUrl;
        return this;
    }
}
