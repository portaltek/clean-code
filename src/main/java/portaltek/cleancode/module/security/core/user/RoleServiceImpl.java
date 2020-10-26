package portaltek.cleancode.module.security.core.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.core.published.domain.RoleDO;
import portaltek.cleancode.module.security.core.published.port.spi.repo.RoleRepoPort;
import portaltek.cleancode.module.security.core.published.service.RoleService;


@Service
class RoleServiceImpl implements RoleService {

    private RoleRepoPort port;

    @Autowired
    public RoleServiceImpl(RoleRepoPort port) {
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
        return false;
//        try {
//            roleRepo.deleteById(id);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }

    }

}
