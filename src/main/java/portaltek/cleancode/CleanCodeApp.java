package portaltek.cleancode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import portaltek.cleancode.module.security.spi.repo.model.Role;
import portaltek.cleancode.module.security.spi.repo.model.User;
import portaltek.cleancode.module.security.domain.service.RoleService;
import portaltek.cleancode.module.security.domain.service.UserService;

import javax.transaction.Transactional;

@SpringBootApplication
public class CleanCodeApp implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(CleanCodeApp.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Role role_admin = new Role("ADMIN");
        Role role_user = new Role("USER");
        roleService.create(role_admin);
        roleService.create(role_user);

        User admin = new User("admin", "admin", true);
        admin.addRole(role_admin);
        admin.addRole(role_user);

        User u = new User("user", "user", true);
        u.addRole(role_user);

        userService.create(admin);
        userService.create(u);
    }
}
