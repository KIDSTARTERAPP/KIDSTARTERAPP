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

@Controller
public class MainController {

    @Autowired
    private JobService jobService;

    @Autowired
    private TagService tagService;

    @Autowired
    OrganizationService organizationService;

    @RequestMapping("/main")
    public String showMain(Model model) {
        return "main";
    }

    @RequestMapping("/admin")
    public String showAdminPage() {
        return "admin-page";
    }

    @RequestMapping("/mentor")
    public String showMentorPage() {
        return "mentor-page";
    }

    @RequestMapping("/active-requests")
    public String getActiveRequests() {
        return "active-requests";
    }

    @RequestMapping("/profile")
    public String showProfilePage() {
        return "profile-page";
    }

    //----------------------------------------------------------

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
    public String showTagsPage(Model model) {
        model.addAttribute("tags", tagService.getAllTag());
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