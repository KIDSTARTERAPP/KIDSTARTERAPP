package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/users")
    public String getAllUsers() {
        return "allUsersForAdmin";
    }

    @RequestMapping("/organizations")
    public String getAllOrganizations() {
        return "allOrganizationsForAdmin";
    }

    @RequestMapping("/tags")
    public String getAllTags() {
        return "allTagsForAdmin";
    }

    @RequestMapping("/jobs")
    public String getAllJobs() {
        return "allJobsForAdmin";
    }

    @RequestMapping("/mentors")
    public String getAllMentors() {
        return "allMentorsForAdmin";
    }

    @RequestMapping("/sponsors")
    public String getAllSponsors() {
        return "allSponsorsForAdmin";
    }

}
