package portaltek.cleancode.module.security.domain.published.core;


import java.util.HashSet;

public class UserDOBuilder {
    public static UserDO get(String username) {
        return UserDO.builder()
                .username(username)
                .password(username)
                .roles(new HashSet<>())
                .enabled(true)
                .build();
    }
}
