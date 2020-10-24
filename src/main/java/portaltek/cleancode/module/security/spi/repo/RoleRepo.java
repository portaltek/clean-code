package portaltek.cleancode.module.security.spi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.module.security.spi.repo.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
