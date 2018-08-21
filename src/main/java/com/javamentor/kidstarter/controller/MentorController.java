package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorController {


    @GetMapping(value = "/home/add_mentor")
    public String  getRegistrationMentor(Model model){
        return "createMentor";
    }
}
