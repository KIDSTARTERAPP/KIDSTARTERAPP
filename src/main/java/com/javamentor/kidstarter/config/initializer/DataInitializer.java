package com.javamentor.kidstarter.config.initializer;

import com.javamentor.kidstarter.model.Role;
import com.javamentor.kidstarter.model.User;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Arrays;

public class DataInitializer {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    public void init(){

        Role rol1e1 = new Role("ADMIN");
        Role role2 = new Role("USER");

        roleService.addRole(rol1e1);
        roleService.addRole(role2);

        Role roleAdmin = roleService.getByName("ADMIN");
        Role roleUser = roleService.getByName("USER");

        User user1  = new User("Ivan","Ivanov","Ivanovich","qwer","1234",
                Arrays.asList(roleAdmin,roleUser), LocalDateTime.now(), 23, "MALE",23-12-34,
                "admin@mail.ru","RUSSIA","house 8");


        userService.addUser(user1);


    }
}
