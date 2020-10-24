package portaltek.cleancode.module.security.spi.datastore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.module.security.spi.datastore.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
