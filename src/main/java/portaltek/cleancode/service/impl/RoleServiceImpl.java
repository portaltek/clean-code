/**
 * 
 */
package portaltek.cleancode.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.repository.RoleRepo;
import portaltek.cleancode.model.Role;
import portaltek.cleancode.service.RoleService;


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
