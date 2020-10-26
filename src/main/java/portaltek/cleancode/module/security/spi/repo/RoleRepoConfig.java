package portaltek.cleancode.module.security.spi.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import portaltek.cleancode.infra.util.AppProfile;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;

import javax.transaction.Transactional;

@Configuration
class RoleRepoConfig {

    @Transactional
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
