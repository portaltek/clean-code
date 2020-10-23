/**
 * 
 */
package portaltek.cleancode.token.core.service;


import portaltek.cleancode.token.spi.datastore.model.Role;


public interface RoleService {

	public Role create(Role role);
	public Role read(Integer id);
	public Role update(Role role);
	public boolean delete(Integer id);
}
