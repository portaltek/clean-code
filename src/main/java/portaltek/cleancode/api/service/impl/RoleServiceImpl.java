/**
 * 
 */
package portaltek.cleancode.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.api.repository.RoleRepo;
import portaltek.cleancode.api.model.Role;
import portaltek.cleancode.api.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepo roleRepo;
	
	@Autowired
	public RoleServiceImpl(RoleRepo roleRepo) {
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
