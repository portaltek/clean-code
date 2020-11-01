package portaltek.cleancode.module.security.api.web.user;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.module.security.core.jwt.JwtUtil;
import portaltek.cleancode.module.security.core.published.service.UserService;


@Configuration
class UserWebConfig {

    @Bean
    UserWebPort userWebPort(JwtUtil jwt, UserService user){
        return new UserWebPort(jwt, user, new UserDtoConverter());
    }


}
