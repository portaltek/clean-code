package portaltek.cleancode.module.security.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;
import portaltek.cleancode.module.security.spi.repo.NoRecordFoundException;
import portaltek.cleancode.module.security.spi.repo.RoleRepo;
import portaltek.cleancode.module.security.spi.repo.Role;
import portaltek.cleancode.module.security.domain.published.service.RoleService;


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
    public Role create(Role role) {

        return roleRepo.save(role);
    }

    @Override
    public Role read(Integer id) {
        return roleRepo.findById(id)
                .orElseThrow(NoRecordFoundException::new);
    }

    @Override
    public Role update(Role role) {
        return roleRepo.save(role);
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
