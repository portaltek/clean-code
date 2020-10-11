package portaltek.cleancode.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.api.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
