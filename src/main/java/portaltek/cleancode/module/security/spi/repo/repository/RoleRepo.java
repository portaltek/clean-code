package portaltek.cleancode.module.security.spi.repo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.module.security.spi.repo.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
