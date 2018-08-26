package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/users")
    public String getAllUsers() {
        return "admin-page";
    }

    @RequestMapping("/organizations")
    public String getAllOrganizations() {
        return "organizationPage";
    }

    @RequestMapping("/tags")
    public String getAllTags() {
        return "tagPage";
    }

    @RequestMapping("/jobs")
    public String getAllJobs() {
        return "jobPage";
    }

    @RequestMapping("/mentors")
    public String getAllMentors() {
        return "all-mentors-admin";
    }

    @RequestMapping("/sponsors")
    public String getAllSponsors() {
        return "all-sponsors-admin";
    }

}
