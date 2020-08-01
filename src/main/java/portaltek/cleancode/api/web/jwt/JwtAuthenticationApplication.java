package portaltek.cleancode.api.web.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import portaltek.cleancode.api.web.jwt.model.Role;
import portaltek.cleancode.api.web.jwt.model.User;
import portaltek.cleancode.api.web.jwt.service.IRoleService;
import portaltek.cleancode.api.web.jwt.service.IUserService;

import javax.transaction.Transactional;

@SpringBootApplication
public class JwtAuthenticationApplication implements CommandLineRunner {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
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
