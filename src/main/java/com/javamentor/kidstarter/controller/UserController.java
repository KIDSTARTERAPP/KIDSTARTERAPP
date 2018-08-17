package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @RequestMapping("/main")
    public String showMain() {
        return "main";
    }
}



