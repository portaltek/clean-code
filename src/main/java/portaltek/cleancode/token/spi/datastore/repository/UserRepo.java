/**
 *
 */
package portaltek.cleancode.token.spi.datastore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.token.spi.datastore.model.User;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
