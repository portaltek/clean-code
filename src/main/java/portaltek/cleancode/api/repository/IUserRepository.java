/**
 *
 */
package portaltek.cleancode.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import portaltek.cleancode.api.model.User;


public interface IUserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
