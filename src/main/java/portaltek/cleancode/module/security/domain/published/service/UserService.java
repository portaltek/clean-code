package portaltek.cleancode.module.security.domain.published.service;


import portaltek.cleancode.module.security.domain.published.core.UserDO;


public interface UserService {

    public UserDO findUserByUsername(String username);

    public UserDO create(UserDO u);

    public UserDO read(Long id);

    public UserDO update(UserDO u);

    public void delete(Long id);

}
