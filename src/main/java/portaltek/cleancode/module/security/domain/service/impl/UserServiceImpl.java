/**
 * 
 */
package portaltek.cleancode.module.security.domain.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;
import portaltek.cleancode.module.security.spi.repo.UserRepo;
import portaltek.cleancode.module.security.spi.repo.Role;
import portaltek.cleancode.module.security.spi.repo.User;
import portaltek.cleancode.module.security.domain.published.service.RoleService;
import portaltek.cleancode.module.security.domain.published.service.UserService;

import javax.transaction.Transactional;


@Service
@Transactional
class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	private RoleService roleService;
	private PasswordEncoder passwordEncoder;
	private UserRepoPort port;

	@Autowired
	public UserServiceImpl(UserRepo userRepo,
												 RoleService roleService,
												 PasswordEncoder passwordEncoder,
												 UserRepoPort port) {
		this.userRepo = userRepo;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
		this.port = port;
	}




	@Override
	public User findUserByUsername(String username) {

		return userRepo.findByUsername(username);
	}

	@Override
	public User create(User u) {
		String hashedPass = passwordEncoder.encode(u.getPassword());
		u.setPassword(hashedPass);
		u.setEnabled(true);
		Role role = roleService.read(2);
		u.addRole(role);
		return userRepo.save(u);
	}

	@Override
	public UserDO read(Long id) {
		return port.findUserById(id);
	}

	@Override
	public User update(User u) {
		return userRepo.save(u);
	}

	@Override
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
}
