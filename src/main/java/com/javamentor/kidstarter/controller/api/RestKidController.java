package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.*;
import com.javamentor.kidstarter.service.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RestKidController {

    static final Logger logger = LoggerFactory.getLogger(RestKidController.class);

    @Autowired
    private KidService kidService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/organization/kids/{id_kid}")
    public ResponseEntity<?> getKidId(@PathVariable("id_kid") long id_kid) {
        User user = userService.getUserById(id_kid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/organization/kids/create")
    public HttpStatus addKid(@RequestBody User user) {




        List<Role> roles = new ArrayList<>();
        Role userRole = roleService.getByName("USER");
        Role userKid = roleService.getByName("KID");
        roles.add(userRole);
        roles.add(userKid);
        user.setRoles(roles);
        user.setCreateDate(LocalDateTime.now());
        user.setAccount(accountService.addAccount(new Account()));
        userService.addUser(user);
        Kid kid = new Kid();
        kid.setUser(user);
        kid.setOrganization(organizationService.getOrganizationByUserId(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
        kidService.addKid(kid);
        return HttpStatus.OK;
    }

    @PutMapping("/organization/kids/{id_kid}")
    public ResponseEntity<?> updateKid(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/organization/kid/{id_kid}")
    public HttpStatus deleteKidById(@PathVariable("id_kid") long id_kid) {
        userService.deleteKidByUserId(id_kid);
        userService.deleteUserById(id_kid);
        return HttpStatus.OK;
    }
}
