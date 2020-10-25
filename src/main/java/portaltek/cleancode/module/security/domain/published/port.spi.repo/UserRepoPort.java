package portaltek.cleancode.module.security.domain.published.port.spi.repo;


import portaltek.cleancode.module.security.domain.published.core.UserDO;


public interface UserRepoPort {

    UserDO findUserById(Long id);
    UserDO findUserByUsername(String username);
    UserDO create(UserDO u);
}
