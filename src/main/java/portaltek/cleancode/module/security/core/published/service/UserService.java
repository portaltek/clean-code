package portaltek.cleancode.module.security.core.published.service;


import portaltek.cleancode.module.security.core.published.domain.UserDO;


public interface UserService {

    UserDO findUserByUsername(String username);

    UserDO create(UserDO u);

    UserDO read(Long id);

    UserDO update(UserDO u);

    void delete(Long id);

}
