package portaltek.cleancode.module.security.api.web.user;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.module.security.domain.published.service.JwtService;
import portaltek.cleancode.module.security.domain.published.service.UserService;


@Configuration
class UserWebConfig {

    @Bean
    UserWebPort userWebPort(JwtService jwt, UserService user){
        return new UserWebPort(jwt, user, new UserDtoConverter());
    }


}
