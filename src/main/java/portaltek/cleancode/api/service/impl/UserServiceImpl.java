/**
 * 
 */
package portaltek.cleancode.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portaltek.cleancode.api.repository.UserRepo;
import portaltek.cleancode.api.model.Role;
import portaltek.cleancode.api.model.User;
import portaltek.cleancode.api.service.RoleService;
import portaltek.cleancode.api.service.UserService;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	private RoleService roleService;
	
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, RoleService roleService) {
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
