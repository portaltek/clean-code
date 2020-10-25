package portaltek.cleancode.module.security.spi.repo;


import org.springframework.data.jpa.repository.JpaRepository;

interface RoleRepo extends JpaRepository<Role, Integer> {

}
