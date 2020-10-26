package portaltek.cleancode.module.security.core.jwt;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import portaltek.cleancode.module.security.core.published.domain.RoleDO;
import portaltek.cleancode.module.security.core.published.domain.UserDO;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserDO user) {
        return new JwtUser(
                user.id(),
                user.username(),
                user.password(),
                map(user.roles()),
                user.enabled());
    }

    private static List<GrantedAuthority> map(Set<RoleDO> authorities) {
        return authorities.stream()
                .map(JwtUserFactory::createAuth)
                .collect(Collectors.toList());
    }


    private static SimpleGrantedAuthority createAuth(RoleDO authority) {
        return new SimpleGrantedAuthority("ROLE_"
                + authority.name().toUpperCase());
    }

}
