package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.module.security.core.published.domain.UserDO;
import portaltek.cleancode.module.security.core.published.port.spi.repo.UserRepoPort;

class UserRepoPortImpl implements UserRepoPort {

    final private UserRepo userRepo;
    final private RoleRepo roleRepo;
    final private UserConverter userConverter;


    public UserRepoPortImpl(UserRepo userRepo, RoleRepo roleRepo,
                            UserConverter userConverter) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.userConverter = userConverter;

    }

    public UserDO findUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(NoRecordFoundException::new);
        return userConverter.toDomain(user);
    }

    public UserDO findUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        return userConverter.toDomain(user);
    }

    public UserDO create(UserDO u) {
        User user = userConverter.fromDomain(u);
        userRepo.save(user);
        return userConverter.toDomain(user);
    }
}
