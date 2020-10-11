/**
 * 
 */
package portaltek.cleancode.api.service;


import portaltek.cleancode.api.model.Role;


public interface RoleService {

	public Role create(Role role);
	public Role read(Integer id);
	public Role update(Role role);
	public boolean delete(Integer id);
}
