package portaltek.cleancode.module.security.domain.jwt;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.spi.repo.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserDO user) {
        return new JwtUser(
                user.id(),
                user.username(),
                user.password(),
                mapToGrantedAuthorities(new ArrayList<Role>(user.roles())),
                user.enabled());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getRoleName().toUpperCase()))
                .collect(Collectors.toList());
    }
}
