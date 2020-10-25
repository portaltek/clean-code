package portaltek.cleancode.module.security.domain.published.core;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Builder
@Accessors(fluent = true)
public class UserDO {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
}
