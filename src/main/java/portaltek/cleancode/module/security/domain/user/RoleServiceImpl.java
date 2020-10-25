/**
 * 
 */
package portaltek.cleancode.module.security.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.spi.repo.RoleRepo;
import portaltek.cleancode.module.security.spi.repo.Role;
import portaltek.cleancode.module.security.domain.published.service.RoleService;


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
