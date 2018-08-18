package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeRestController {

    private final UserService userService;

    @Autowired
    public HomeRestController(UserService userService) {
        this.userService = userService;
    }
//    @RequestMapping(value = "/registration",  method = RequestMethod.POST)
//    public String registration(){
//
//    }

}
