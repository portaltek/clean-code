package portaltek.cleancode.core.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import portaltek.cleancode.spi.datastore.model.Role;
import portaltek.cleancode.spi.datastore.model.User;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<Role>(user.getRoles())),
                user.isEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getRoleName().toUpperCase()))
                .collect(Collectors.toList());
    }
}
