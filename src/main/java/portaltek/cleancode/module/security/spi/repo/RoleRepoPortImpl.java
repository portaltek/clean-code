package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;

class RoleRepoPortImpl implements RoleRepoPort {

    private RoleRepo roleRepo;

    public RoleRepoPortImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public RoleDO create(RoleDO role) {
        return null;
    }

    @Override
    public RoleDO read(Integer id) {
        return null;
    }

    @Override
    public RoleDO update(RoleDO role) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
