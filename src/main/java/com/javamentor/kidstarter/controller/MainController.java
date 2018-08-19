package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @RequestMapping("/main")
    public String showMain() {
        return "main";
    }

    @RequestMapping("/tagPage")
    public String tagPage() {
        return "tagPage";
    }

    @RequestMapping("/jobPage")
    public String jobPage() {
        return "jobPage";
    }

    @RequestMapping("/createUser")
    public String createUserPage() {
        return "createUser";
    }
}