package com.cocovo.fitqaspringjava.interfaces.user;

import com.cocovo.fitqaspringjava.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

public class UserDto {

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String name;
        private final String email;
        private final String photoURL;
        private final User.AccountProvider provider;

        private final String attributeKey;
        private final Map<String, Object> attributes;
    }

    public static UserDto.Main of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        switch (registrationId) {
            case "naver":
                return ofNaver("id", attributes);
            case "kakao":
                return ofKakao(userNameAttributeName, attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static Main ofGoogle(String attributeKey, Map<String, Object> attributes) {
        return Main.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .photoURL((String) attributes.get("picture"))
                .provider(User.AccountProvider.GOOGLE)
                .attributeKey(attributeKey)
                .attributes(attributes)
                .build();
    }

    private static Main ofKakao(String attributeKey, Map<String, Object> attributes) {
        var response = (Map<String, Object>)attributes.get("kakao_account");
        var profile = (Map<String, Object>) response.get("profile");
        return Main.builder()
                .name((String) profile.get("nickname"))
                .email((String) response.get("email"))
                .photoURL((String) profile.get("profile_image_url"))
                .provider(User.AccountProvider.KAKAO)
                .attributeKey(attributeKey)
                .attributes(attributes)
                .build();
    }

    private static Main ofNaver(String attributeKey, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");
        return Main.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .photoURL((String) response.get("profile_image"))
                .provider(User.AccountProvider.NAVER)
                .attributeKey(attributeKey)
                .attributes(attributes)
                .build();
    }


}
