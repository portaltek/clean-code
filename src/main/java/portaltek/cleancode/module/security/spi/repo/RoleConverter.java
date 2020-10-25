package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;

class RoleConverter implements Converter<Role, RoleDO> {


    @Override
    public Role fromDomain(RoleDO domain) {
        Role dto = new Role();
        dto.setId(domain.id());
        dto.setRoleName(domain.name());
        return dto;
    }

    @Override
    public RoleDO toDomain(Role dto) {
        return RoleDO.builder()
                .id(dto.getId())
                .name(dto.getRoleName())
                .build();
    }

}
