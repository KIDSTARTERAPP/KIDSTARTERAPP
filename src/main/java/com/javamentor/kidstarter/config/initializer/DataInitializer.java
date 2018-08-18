package com.javamentor.kidstarter.config.initializer;

import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataInitializer {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    public void init(){

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("TEACHER");
        Role role3 = new Role("SPONSOR");
        Role role4 = new Role("OWNER");
        Role role5 = new Role("MENTOR");
        Role role6 = new Role("MODERATOR");
        Role role7 = new Role("KID");

        roleService.addRole(role1);
        roleService.addRole(role2);
        roleService.addRole(role3);
        roleService.addRole(role4);
        roleService.addRole(role5);
        roleService.addRole(role6);
        roleService.addRole(role7);

        Role roleAdmin = roleService.getByName("ADMIN");
        Role roleTeacher = roleService.getByName("TEACHER");
        Role roleSponsor = roleService.getByName("SPONSOR");
        Role roleOwner = roleService.getByName("OWNER");
        Role roleMentor = roleService.getByName("MENTOR");
        Role roleModerator = roleService.getByName("MODERATOR");
        Role roleKid = roleService.getByName("KID");
        List<Role> roles = new ArrayList<>();
        Collections.addAll (roles, roleAdmin,roleTeacher,roleSponsor, roleOwner, roleMentor, roleModerator, roleKid);

        User user1  = new User("Ivan","Ivanov","Ivanovich","qwer","1234",
                roles,
                LocalDateTime.now(), 23, "MALE",23-12-34,
                "admin@mail.ru","RUSSIA","house 8");


        userService.addUser(user1);

    }
}
