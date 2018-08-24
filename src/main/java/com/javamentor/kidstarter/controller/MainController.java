package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import com.javamentor.kidstarter.service.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private JobService jobService;

    @Autowired
    private TagService tagService;

    @Autowired
    OrganizationService organizationService;

    @RequestMapping("/main")
    public String showMain() {
        return "main";
    }

    @RequestMapping("/cretejobtag")
    public String showCreateJobTag() {
        return "cretejobtag";
    }

    @RequestMapping("/adminpage")
    public String showAdminPage() {
        return "adminpage";
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

    @GetMapping("/createKid")
    public String createKidPage() {
        return "createKid";
    }

    @GetMapping("/tagPage")
    public String showTagsPage() {
        return "tagPage";
    }

    @RequestMapping("/organizationPage")
    public String showListOrganizationPage() {
        return "organizationPage";
    }

    @RequestMapping("/createOrganization")
    public String createOrganizationPage() {
        return "createOrganization";
    }

    @GetMapping("/editJob/{id}")
    public String showEditJob(@PathVariable("id") Long id) {
        return "editJob";
    }
    @RequestMapping("/createTeacher")
    public String createTeacher() {
        return "createTeacher";
    }
}