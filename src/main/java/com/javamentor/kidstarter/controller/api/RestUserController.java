package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class RestUserController {

    @Autowired
    public UserService userService;


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserId(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUser() {
        List<User>tag = userService.getAllUser();
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@ModelAttribute("user") User currentUser) {
        userService.addUser(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?>  updateTag(@ModelAttribute("user") User newUser, @PathVariable("id") long id) {
        userService.updateUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}



