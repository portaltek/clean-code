package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;

class RoleRepoPortImpl implements RoleRepoPort {

    private RoleRepo roleRepo;

    public RoleRepoPortImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public Role read(Integer id) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
