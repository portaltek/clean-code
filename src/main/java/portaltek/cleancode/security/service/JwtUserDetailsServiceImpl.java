package portaltek.cleancode.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.repository.UserRepo;
import portaltek.cleancode.security.JwtUserFactory;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;


@Service
@Transactional
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private UserRepo userRepo;
    private String NOT_FOUND = "No user found with username '%s'.";

    @Autowired
    public JwtUserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ofNullable(userRepo.findByUsername(username))
                .map(e -> JwtUserFactory.create(e))
                .orElseThrow(() -> new UsernameNotFoundException(format(NOT_FOUND, username)));
    }
}
