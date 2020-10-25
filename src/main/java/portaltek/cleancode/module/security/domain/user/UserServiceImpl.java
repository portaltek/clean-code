package portaltek.cleancode.module.security.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;
import portaltek.cleancode.module.security.domain.published.service.RoleService;
import portaltek.cleancode.module.security.domain.published.service.UserService;


@Service
class UserServiceImpl implements UserService {

    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private UserRepoPort port;
    private RoleRepoPort rolePort;

    @Autowired
    public UserServiceImpl(RoleService roleService,
                           PasswordEncoder passwordEncoder,
                           UserRepoPort port, RoleRepoPort rolePort) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.port = port;
        this.rolePort = rolePort;
    }


    @Override
    public UserDO findUserByUsername(String username) {
        return port.findUserByUsername(username);
    }

    @Override
    public UserDO create(UserDO u) {
        String hashedPass = passwordEncoder.encode(u.password());
        RoleDO role = rolePort.read(2);

        u.password(hashedPass)
                .enabled(true)
                .roles().add(role);
        return port.create(u);
    }

    @Override
    public UserDO read(Long id) {
        return port.findUserById(id);
    }

    @Override
    public UserDO update(UserDO u) {
        //return userRepo.save(u);
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
//		userRepo.deleteById(id);
        throw new UnsupportedOperationException();
    }
}
