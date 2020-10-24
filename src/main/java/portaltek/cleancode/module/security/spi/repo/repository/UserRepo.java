/**
 *
 */
package portaltek.cleancode.module.security.spi.repo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.module.security.spi.repo.model.User;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
