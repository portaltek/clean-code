package portaltek.cleancode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
