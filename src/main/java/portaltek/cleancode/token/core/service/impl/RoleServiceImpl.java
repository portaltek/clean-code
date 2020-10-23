/**
 * 
 */
package portaltek.cleancode.token.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.token.spi.datastore.repository.RoleRepo;
import portaltek.cleancode.token.spi.datastore.model.Role;
import portaltek.cleancode.token.core.service.RoleService;


@Service
class RoleServiceImpl implements RoleService {

	private RoleRepo roleRepo;
	
	@Autowired
	public RoleServiceImpl(RoleRepo roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}

	@Override
	public Role create(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role read(Integer id) {
		return roleRepo.findById(id).get();
	}

	@Override
	public Role update(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public boolean delete(Integer id) {
		try{
			roleRepo.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}

}
