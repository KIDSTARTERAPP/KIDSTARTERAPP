package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/profile")
    public String getUserProfile() {
        return "userProfile";
    }

    @RequestMapping("/add-organization")
    public String addOrganization() {
        return "addOrganization";
    }

}
