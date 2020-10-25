package portaltek.cleancode.module.security.domain.published.core;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import portaltek.cleancode.module.security.spi.repo.Role;

import java.util.Set;


@Data
@Builder
@Accessors(fluent = true)
public class UserDO {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Set<Role> roles;
}
