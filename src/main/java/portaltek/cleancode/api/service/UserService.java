package portaltek.cleancode.api.service;


import portaltek.cleancode.api.model.User;

public interface UserService {
	
	public User findUserByUsername(String username);
	public User create(User u);
	public User read(Long id);
	public User update(User u);
	public void delete(Long id);

}
