package portaltek.cleancode.module.security.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;
import portaltek.cleancode.module.security.domain.published.service.RoleService;
import portaltek.cleancode.module.security.spi.repo.RoleRepo;


@Service
class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;
    private RoleRepoPort port;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo, RoleRepoPort port) {
        this.roleRepo = roleRepo;
        this.port = port;
    }

    @Override
    public RoleDO create(RoleDO role) {
        return port.create(role);
    }

    @Override
    public RoleDO read(Integer id) {
        return port.read(id);
    }

    @Override
    public RoleDO update(RoleDO role) {
        return null;
    }


    @Override
    public boolean delete(Integer id) {
        try {
            roleRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

}
