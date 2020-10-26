package portaltek.cleancode.module.security.core.published.domain;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@Accessors(fluent = true)
public class UserDO {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Set<RoleDO> roles;

    public static UserDO get() {
        return builder().build();
    }

    public static UserDO get(String username) {
        return builder()
                .username(username)
                .password(username)
                .roles(new HashSet<>())
                .enabled(true)
                .build();
    }
}
