package portaltek.cleancode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import portaltek.cleancode.module.security.core.published.domain.RoleDO;
import portaltek.cleancode.module.security.core.published.domain.UserDO;
import portaltek.cleancode.module.security.core.published.service.RoleService;
import portaltek.cleancode.module.security.core.published.service.UserService;

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
    public void run(String... args) {


        RoleDO roleDOAdmin = RoleDO.get("ADMIN");
        RoleDO roleDOUser = RoleDO.get("USER");
        roleService.create(roleDOAdmin);
        roleService.create(roleDOUser);

        UserDO adminDO = UserDO.get("admin");
        adminDO.roles().add(roleDOAdmin);
        adminDO.roles().add(roleDOUser);
        userService.create(adminDO);

        UserDO userDO = UserDO.get("user");
        userDO.roles().add(roleDOUser);
        userService.create(userDO);


    }
}
