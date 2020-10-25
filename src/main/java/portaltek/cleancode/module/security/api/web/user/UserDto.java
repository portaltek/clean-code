package portaltek.cleancode.module.security.api.web.user;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(fluent = true)
class UserDto {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
}
