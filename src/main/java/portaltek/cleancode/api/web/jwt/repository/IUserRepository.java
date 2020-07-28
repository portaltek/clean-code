/**
 *
 */
package portaltek.cleancode.api.web.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.api.web.jwt.model.User;


public interface IUserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
