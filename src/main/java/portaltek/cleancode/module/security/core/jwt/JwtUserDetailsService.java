package portaltek.cleancode.module.security.core.jwt;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import portaltek.cleancode.module.security.core.published.port.spi.repo.UserRepoPort;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;


class JwtUserDetailsService implements UserDetailsService {

    static final String NOT_FOUND = "No user found with username '%s'.";
    private UserRepoPort port;


    public JwtUserDetailsService(UserRepoPort port) {
        this.port = port;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ofNullable(port.findUserByUsername(username))
                .map(JwtUserFactory::create)
                .orElseThrow(() -> usernameNotFound(username));
    }

    public UsernameNotFoundException usernameNotFound(String username) {
        return new UsernameNotFoundException(format(NOT_FOUND, username));
    }
}
