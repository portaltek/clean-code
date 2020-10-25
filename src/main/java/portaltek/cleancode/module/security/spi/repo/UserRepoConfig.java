package portaltek.cleancode.module.security.spi.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;

@Configuration
class UserRepoConfig {

    @Bean
    public UserRepoPort userRepoPort(UserRepo userRepo,
                                     RoleRepo roleRepo,
                                     UserConverter converter) {
        return new UserRepoPortImpl(userRepo, roleRepo, converter);
    }

    @Bean
    public UserConverter UserConverter(RoleConverter roleConverter) {
        return new UserConverter(roleConverter);
    }


}
