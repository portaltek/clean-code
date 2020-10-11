/**
 *
 */
package portaltek.cleancode.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.api.model.User;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
