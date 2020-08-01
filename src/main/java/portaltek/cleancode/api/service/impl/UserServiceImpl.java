/**
 * 
 */
package portaltek.cleancode.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portaltek.cleancode.api.repository.IUserRepository;
import portaltek.cleancode.api.model.Role;
import portaltek.cleancode.api.model.User;
import portaltek.cleancode.api.service.IRoleService;
import portaltek.cleancode.api.service.IUserService;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	private IUserRepository userRepo;
	private IRoleService roleService;
	
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(IUserRepository userRepo, PasswordEncoder passwordEncoder, IRoleService roleService) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.roleService = roleService;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public User create(User u) {
		// TODO Auto-generated method stub
		String hashedPass = passwordEncoder.encode(u.getPassword());
		u.setPassword(hashedPass);
		u.setEnabled(true);
		Role role = roleService.read(2);
		u.addRole(role);
		return userRepo.save(u);
	}

	@Override
	public User read(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

	@Override
	public User update(User u) {
		// TODO Auto-generated method stub
		return userRepo.save(u);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}
}
