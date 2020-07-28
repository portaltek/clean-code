/**
 * 
 */
package portaltek.cleancode.api.web.jwt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.api.web.jwt.model.Role;
import portaltek.cleancode.api.web.jwt.repository.IRoleRepository;
import portaltek.cleancode.api.web.jwt.service.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {

	private IRoleRepository roleRepo;
	
	@Autowired
	public RoleServiceImpl(IRoleRepository roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}

	@Override
	public Role create(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role read(Integer id) {
		// TODO Auto-generated method stub
		return roleRepo.findById(id).get();
	}

	@Override
	public Role update(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		try{
			roleRepo.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}

}
