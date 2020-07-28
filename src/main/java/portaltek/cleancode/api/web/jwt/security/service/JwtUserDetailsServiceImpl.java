package portaltek.cleancode.api.web.jwt.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.api.web.jwt.model.User;
import portaltek.cleancode.api.web.jwt.repository.IUserRepository;
import portaltek.cleancode.api.web.jwt.security.JwtUserFactory;


@Service
@Transactional
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
