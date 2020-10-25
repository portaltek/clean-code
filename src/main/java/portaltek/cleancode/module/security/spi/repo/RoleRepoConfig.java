package portaltek.cleancode.module.security.spi.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;

@Configuration
class RoleRepoConfig {

    @Bean
    public RoleRepoPort roleRepoPort(RoleRepo roleRepo,
                                     RoleConverter converter) {
        return new RoleRepoPortImpl(roleRepo, converter);
    }

    @Bean
    public RoleConverter roleConverter() {
        return new RoleConverter();
    }


}
