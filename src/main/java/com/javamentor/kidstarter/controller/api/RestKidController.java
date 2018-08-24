package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.KidService;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/kid/{id}")
    public ResponseEntity<?> getKidId(@PathVariable("id") long id) {
        Kid kid = kidService.getKidById(id);
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }

    @GetMapping("/kids")
    public ResponseEntity<List<Kid>> listAllKids() {
        List<Kid> kid = kidService.getAllKids();
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }

    @DeleteMapping("/kid/{id}")
    public HttpStatus deleteKidById(@PathVariable("id") long id) {
        kidService.deleteKidById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/kid/create")
    public HttpStatus addKid(@RequestBody User user) {
        List<Role> roles = new ArrayList<>();
        Role userRole = roleService.getByName("USER");
        Role userKid = roleService.getByName("KID");
        roles.add(userRole);
        roles.add(userKid);
        user.setRoles(roles);
        user.setCreateDate(LocalDateTime.now());
        userService.addUser(user);
        Kid kid = new Kid();
        kid.setUser(user);
        kidService.addKid(kid);
        return HttpStatus.OK;
    }

    @PutMapping("/kid")
    public ResponseEntity<?>  updateKid(@ModelAttribute("kid") Kid kid) {
        kidService.updateKid(kid);
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }
}
