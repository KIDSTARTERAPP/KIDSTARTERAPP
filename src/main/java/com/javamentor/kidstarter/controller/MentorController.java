package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorController {
    @GetMapping(value = "/mentor/add")
    public String  getRegistrationMentor(Model model){
        return "createMentor";
    }

    @GetMapping("/mentor/requests")
    public String showAvailableRequests() {
        return "mentor_requests";
    }

    @GetMapping("/mentor/activerequests")
    public String showMentorActiveRequests() {
        return "mentor_active_requests";
    }

}
