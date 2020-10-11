package portaltek.cleancode.api.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.api.model.User;
import portaltek.cleancode.api.repository.UserRepo;
import portaltek.cleancode.api.security.JwtUserFactory;

import static java.lang.String.format;


@Service
@Transactional
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private UserRepo userRepo;
    private String USER_NOT_FOUND = "No user found with username '%s'.";

    @Autowired
    public JwtUserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(format(USER_NOT_FOUND, username));
        } else {
            return JwtUserFactory.create(user);
        }


//        return Optional.ofNullable(userRepo.findByUsername(username))
//                .map(e -> JwtUserFactory.create(e))
//                .orElseThrow(() -> new UsernameNotFoundException(format(USER_NOT_FOUND, username)));

    }
}
