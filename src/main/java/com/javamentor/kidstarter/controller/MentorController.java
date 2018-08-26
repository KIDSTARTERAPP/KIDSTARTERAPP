package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorController {
    @GetMapping(value = "/main/become-mentor")
    public String  getRegistrationMentor( ){
        return "createMentor";
    }
}
