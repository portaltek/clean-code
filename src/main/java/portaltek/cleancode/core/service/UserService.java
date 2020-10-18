package portaltek.cleancode.core.service;


import portaltek.cleancode.spi.datastore.model.User;

public interface UserService {
	
	public User findUserByUsername(String username);
	public User create(User u);
	public User read(Long id);
	public User update(User u);
	public void delete(Long id);

}
