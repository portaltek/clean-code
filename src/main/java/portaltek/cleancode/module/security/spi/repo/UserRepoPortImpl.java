/**
 *
 */
package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;

class UserRepoPortImpl implements UserRepoPort {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private UserConverter userConverter;

    public UserRepoPortImpl(UserRepo userRepo,
                            RoleRepo roleRepo,
                            UserConverter userConverter) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.userConverter = userConverter;
    }

    public UserDO findUserById(Long id){
        User user = userRepo.findById(id).get();
        return userConverter.toDomain(user);
    }
}
