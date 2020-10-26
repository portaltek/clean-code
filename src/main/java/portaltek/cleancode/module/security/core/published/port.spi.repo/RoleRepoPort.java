package portaltek.cleancode.module.security.core.published.port.spi.repo;


import portaltek.cleancode.module.security.core.published.domain.RoleDO;


public interface RoleRepoPort {

    RoleDO create(RoleDO role);

    RoleDO read(Integer id);

    RoleDO update(RoleDO role);

    boolean delete(Integer id);
}
