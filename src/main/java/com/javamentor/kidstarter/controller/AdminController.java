package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/cretejobtag")
    public String showCreateJobTag() {
        return "cretejobtag";
    }

    @GetMapping("/editUser/{id}")
    public String showUserEdit(@PathVariable("id") String id) {
        return "editUser";
    }

    @GetMapping("/editOrganization/{id}")
    public String showOrganizationEdit(@PathVariable("id") String id) {
        return "editOrganization";
    }

    @GetMapping("/jobPage")
    public String showJobPage() {
        return "jobPage";
    }

    @GetMapping("/createUser")
    public String createUserPage() {
        return "createUser";
    }

    @GetMapping("/tagPage")
    public String showTagsPage() {
        return "tagPage";
    }

    @RequestMapping("/organizationPage")
    public String showListOrganizationPage() {
        return "organizationPage";
    }

    @RequestMapping("/create-organization")
    public String createOrganizationPage() {
        return "create-organization";
    }

    @GetMapping("/editJob/{id}")
    public String showEditJob(@PathVariable("id") Long id) {
        return "editJob";
    }
}
