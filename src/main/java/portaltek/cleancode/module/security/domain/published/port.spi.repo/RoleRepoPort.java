package portaltek.cleancode.module.security.domain.published.port.spi.repo;


import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.spi.repo.Role;


public interface RoleRepoPort {

    public Role create(Role role);
    public Role read(Integer id);
    public Role update(Role role);
    public boolean delete(Integer id);
}
