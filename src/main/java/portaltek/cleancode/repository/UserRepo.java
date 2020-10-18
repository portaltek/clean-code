/**
 *
 */
package portaltek.cleancode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.model.User;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
