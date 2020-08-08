package portaltek.cleancode.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.api.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
