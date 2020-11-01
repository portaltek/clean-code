package portaltek.cleancode.module.security.core.jwt;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.module.security.core.published.port.spi.repo.UserRepoPort;
import portaltek.cleancode.module.security.core.published.service.JwtService;


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

    @Bean
    public JwtGenerator jwtGeneratorImpl(UserDetailsService userDetailsService) {
        return new JwtGeneratorImpl(secret, expiration, userDetailsService);
    }

    @Transactional
    @Bean
    public JwtUserDetailsService jwtUserDetailsService(UserRepoPort port) {
        return new JwtUserDetailsService(port);
    }

}
