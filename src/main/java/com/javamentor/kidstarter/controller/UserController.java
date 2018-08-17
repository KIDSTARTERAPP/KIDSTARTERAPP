package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.service_abstract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    public UserService serviceClass;


    @RequestMapping("/main")
    public String showMain() {
        return "main";
    }

}



