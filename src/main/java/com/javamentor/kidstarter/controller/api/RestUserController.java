package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RestUserController {

    @Autowired
    public UserService userService;

    @Autowired
    public RoleService roleService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserId(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> tag = userService.getAllUser();
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User currentUser) {
        currentUser.setCreateDate(LocalDateTime.now());
        userService.addUser(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }


    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User newUser) {
        userService.updateUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/user/current")
    public ResponseEntity<User> getCurrentUser() {
        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(current, HttpStatus.OK);
    }
}