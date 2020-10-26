package portaltek.cleancode.module.security.core.published.service;


import portaltek.cleancode.module.security.core.published.domain.RoleDO;


public interface RoleService {

    RoleDO create(RoleDO role);

    RoleDO read(Integer id);

    RoleDO update(RoleDO role);

    boolean delete(Integer id);
}
