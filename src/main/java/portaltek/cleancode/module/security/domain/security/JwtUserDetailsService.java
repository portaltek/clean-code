package portaltek.cleancode.module.security.domain.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.module.security.spi.repo.UserRepo;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;


@Service
@Transactional
class JwtUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;
    private String NOT_FOUND = "No user found with username '%s'.";

    @Autowired
    public JwtUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ofNullable(userRepo.findByUsername(username))
                .map(e -> JwtUserFactory.create(e))
                .orElseThrow(() -> new UsernameNotFoundException(format(NOT_FOUND, username)));
    }
}
