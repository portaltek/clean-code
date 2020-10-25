package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.core.UserDO;

class RoleConverter implements Converter<Role, RoleDO> {


    @Override
    public Role fromDomain(RoleDO domain) {
        Role dto = new Role();

        return dto;
    }

    @Override
    public RoleDO toDomain(Role role) {
        return RoleDO.builder()
                .build();
    }
}
