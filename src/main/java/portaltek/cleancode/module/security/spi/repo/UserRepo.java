/**
 *
 */
package portaltek.cleancode.module.security.spi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.module.security.spi.repo.User;


interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
