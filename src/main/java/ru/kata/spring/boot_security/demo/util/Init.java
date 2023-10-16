package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class Init {
    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    //@Autowired
    public Init(RoleServiceImpl roleService, UserServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void initDataBase() {
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");
        Set<Role> adminSet = Set.of(admin);
        roleService.addRole(admin);
        roleService.addRole(user);

        User adminUser = new User();
        adminUser.setId(1);
        adminUser.setRoles(adminSet);
        adminUser.setUsername("admin");
        adminUser.setEmail("email");
        adminUser.setPassword("password");
        userService.add(adminUser);
    }

}
