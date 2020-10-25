package portaltek.cleancode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.domain.published.core.UserDOBuilder;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;
import portaltek.cleancode.module.security.domain.published.service.RoleService;
import portaltek.cleancode.module.security.domain.published.service.UserService;
import portaltek.cleancode.module.security.spi.repo.Role;

import javax.transaction.Transactional;

@SpringBootApplication
public class CleanCodeApp implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRepoPort userPort;


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


        UserDO adminDO = UserDOBuilder.get("admin");
        adminDO.roles().add(role_admin);
        adminDO.roles().add(role_user);
        userService.create(adminDO);

        UserDO userDO = UserDOBuilder.get("user");
        userDO.roles().add(role_user);
        userService.create(userDO);



    }
}
