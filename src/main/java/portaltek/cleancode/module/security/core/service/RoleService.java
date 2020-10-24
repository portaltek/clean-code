/**
 * 
 */
package portaltek.cleancode.module.security.core.service;


import portaltek.cleancode.module.security.spi.datastore.model.Role;


public interface RoleService {

	public Role create(Role role);
	public Role read(Integer id);
	public Role update(Role role);
	public boolean delete(Integer id);
}
