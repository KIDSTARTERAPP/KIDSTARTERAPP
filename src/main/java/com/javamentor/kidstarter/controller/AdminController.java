package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    public String adminProfile() {
        return "admin-page";
    }
    @RequestMapping("/users")
    public String getAllUsers() {
        return "all-users-admin";
    }

    @RequestMapping("/organizations")
    public String getAllOrganizations() {
        return "all-organizations-admin";
    }

    @RequestMapping("/tags")
    public String getAllTags() {
        return "all-tags-admin";
    }

    @RequestMapping("/jobs")
    public String getAllJobs() {
        return "all-jobs-admin";
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
