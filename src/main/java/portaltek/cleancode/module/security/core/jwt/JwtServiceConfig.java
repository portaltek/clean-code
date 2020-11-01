package portaltek.cleancode.module.security.core.jwt;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import portaltek.cleancode.module.security.core.published.port.spi.repo.UserRepoPort;
import portaltek.cleancode.module.security.core.published.service.JwtGenerator;


@Configuration
class JwtServiceConfig {

    @Value("${jwt.secret}")
    String secret;

    @Value("${jwt.expiration}")
    Long expiration;


    @Bean
    public JwtGenerator jwtGenerator(UserDetailsService userDetailsService) {
        return new JwtGeneratorImpl(secret, expiration, userDetailsService);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(secret);
    }

    @Transactional
    @Bean
    public JwtUserDetailsService jwtUserDetailsService(UserRepoPort port) {
        return new JwtUserDetailsService(port);
    }

}
