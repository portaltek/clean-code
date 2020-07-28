package portaltek.cleancode.api.web.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.api.web.jwt.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
