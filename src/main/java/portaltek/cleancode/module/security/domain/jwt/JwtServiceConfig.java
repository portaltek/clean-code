package portaltek.cleancode.module.security.domain.jwt;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.module.security.domain.published.service.JwtService;
import portaltek.cleancode.module.security.spi.repo.UserRepo;


@Configuration
class JwtServiceConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Bean
    public JwtService jwtService(UserDetailsService userDetailsService) {
        return new JwtServiceImpl(secret, expiration, userDetailsService);
    }

    @Transactional
    @Bean
    public JwtUserDetailsService jwtUserDetailsService(UserRepo userRepo) {
        return new JwtUserDetailsService(userRepo);
    }

}
