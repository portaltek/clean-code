package portaltek.cleancode.api.web.jwt.service;


import portaltek.cleancode.api.web.jwt.model.User;

public interface IUserService {
	
	public User findUserByUsername(String username);
	public User create(User u);
	public User read(Long id);
	public User update(User u);
	public void delete(Long id);

}
