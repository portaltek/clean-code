/**
 * 
 */
package portaltek.cleancode.core.service;


import portaltek.cleancode.spi.datastore.model.Role;


public interface RoleService {

	public Role create(Role role);
	public Role read(Integer id);
	public Role update(Role role);
	public boolean delete(Integer id);
}
