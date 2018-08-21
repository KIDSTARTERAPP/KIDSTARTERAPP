package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestRoleController {

    static final Logger logger = LoggerFactory.getLogger(RestTagController.class);

    @Autowired
    public RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Role> getRolesById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @GetMapping("/user_roles/{id}")
    public ResponseEntity<List<Role>> getRolesByUserId(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        List<Role> roles = user.getRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/select_roles")
    public ResponseEntity<List<Role>> getRolesByStringArray(@RequestParam("roles") String list) {
        List<Role> allRoles = roleService.getAllRoles();
        List<Role> roles = new ArrayList<>();
        for (Role role : allRoles) {
            if (list.contains(role.getName())) {
                roles.add(role);
            }
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
