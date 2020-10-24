/**
 * 
 */
package portaltek.cleancode.module.security.domain.service;


import portaltek.cleancode.module.security.spi.repo.Role;


public interface RoleService {

	public Role create(Role role);
	public Role read(Integer id);
	public Role update(Role role);
	public boolean delete(Integer id);
}
