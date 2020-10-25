package portaltek.cleancode.module.security.domain.published.service;


import portaltek.cleancode.module.security.domain.published.core.RoleDO;


public interface RoleService {

    RoleDO create(RoleDO role);

    RoleDO read(Integer id);

    RoleDO update(RoleDO role);

    boolean delete(Integer id);
}
