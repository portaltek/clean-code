package portaltek.cleancode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.core.RoleDOBuilder;
import portaltek.cleancode.module.security.domain.published.core.UserDO;
import portaltek.cleancode.module.security.domain.published.core.UserDOBuilder;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.RoleRepoPort;
import portaltek.cleancode.module.security.domain.published.port.spi.repo.UserRepoPort;
import portaltek.cleancode.module.security.domain.published.service.RoleService;
import portaltek.cleancode.module.security.domain.published.service.UserService;
import portaltek.cleancode.module.security.spi.repo.RoleConverter;

import javax.transaction.Transactional;

@SpringBootApplication
public class CleanCodeApp implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleConverter roleConverter;

    @Autowired
    RoleRepoPort roleRepoPort;
    @Autowired
    UserRepoPort userRepoPort;

    public static void main(String[] args) {
        SpringApplication.run(CleanCodeApp.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {


        RoleDO roleDOAdmin = RoleDOBuilder.get("ADMIN");
        RoleDO roleDOUser = RoleDOBuilder.get("USER");
        roleService.create(roleDOAdmin);
        roleService.create(roleDOUser);

        UserDO adminDO = UserDOBuilder.get("admin");
        adminDO.roles().add(roleDOAdmin);
        adminDO.roles().add(roleDOUser);
        userService.create(adminDO);

        UserDO userDO = UserDOBuilder.get("user");
        userDO.roles().add(roleDOUser);
        userService.create(userDO);

//        Role roleAdmin = new Role("ADMIN");
//        Role roleUser = new Role("USER");
//        Role roleAdmin = roleConverter.fromDomain(roleDOAdmin);
//        Role roleUser = roleConverter.fromDomain(roleDOUser);

//        UserDO adminDO = UserDOBuilder.get("admin");
//        adminDO.roles().add(roleAdmin);
//        adminDO.roles().add(roleUser);
//        userService.create(adminDO);
//
//        UserDO userDO = UserDOBuilder.get("user");
//        userDO.roles().add(roleUser);
//        userService.create(userDO);


    }
}
