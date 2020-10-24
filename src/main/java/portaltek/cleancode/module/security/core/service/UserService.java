package portaltek.cleancode.module.security.core.service;


import portaltek.cleancode.module.security.spi.datastore.model.User;

public interface UserService {
	
	public User findUserByUsername(String username);
	public User create(User u);
	public User read(Long id);
	public User update(User u);
	public void delete(Long id);

}
