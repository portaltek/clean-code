/**
 * 
 */
package portaltek.cleancode.api.web.jwt.service;


import portaltek.cleancode.api.web.jwt.model.Role;


public interface IRoleService {

	public Role create(Role role);
	public Role read(Integer id);
	public Role update(Role role);
	public boolean delete(Integer id);
}
