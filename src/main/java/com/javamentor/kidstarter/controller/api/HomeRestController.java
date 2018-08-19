package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/api/home")
public class HomeRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public HomeRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity registration(@RequestBody User user) {

        Role role = roleService.getByName("ADMIN");

        user.setRoles(Collections.singletonList(role));
        user.setCreateDate(LocalDateTime.now());
        userService.addUser(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
