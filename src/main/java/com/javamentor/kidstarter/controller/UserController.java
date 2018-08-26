package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/main/create-organization")
    public String createOrganization() {
        return "create-organization";
    }

    @RequestMapping("/main/active-requests")
    public String getActiveRequests() {
        return "active-requests";
    }

    @RequestMapping("/main/become-mentor")
    public String becomeMentor() {
        return "createMentor";
    }
}
