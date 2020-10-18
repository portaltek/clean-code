package portaltek.cleancode.spi.datastore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.spi.datastore.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
