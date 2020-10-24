/**
 *
 */
package portaltek.cleancode.module.security.spi.datastore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.module.security.spi.datastore.model.User;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
