package portaltek.cleancode.module.security.domain.published.service;


import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.spi.repo.User;

public interface UserService {
	
	public User findUserByUsername(String username);
	public User create(User u);
	public UserDO read(Long id);
	public User update(User u);
	public void delete(Long id);

}
