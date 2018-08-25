package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import com.javamentor.kidstarter.service.interfaces.RequestService;
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

    @Autowired
    RequestService requestService;

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
    public String showTagsPage(Model model) {
        model.addAttribute("tags", tagService.getAllTag());
        return "tagPage";
    }

    @GetMapping("/requestPage")
    public String showRequestPage(Model model) {
        model.addAttribute("tags", requestService.getAllRequest());
        return "requestPage";
    }

    @RequestMapping("/organizationInfoPage/{id}")
    public String showListOrganizationPage() {
        return "organizationInfoPage";
    }

    @RequestMapping("/organizationPage")
    public String showOrganizationPage() {
        return "organizationPage";
    }

    @RequestMapping("/createOrganization")
    public String createOrganizationPage() {
        return "createOrganization";
    }
    @RequestMapping("/createTeacher")
    public String createTeacher(){
        return "createTeacher";
    }

    @GetMapping("/editJob/{id}")
    public String showEditJob(@PathVariable("id") Long id) {
        return "editJob";
    }

    @GetMapping("/kid")
    public String showKidPage() {
        return "kid_page";
    }

    @GetMapping("/kid/jobs")
    public String showKidJobPickPage() {
        return "kid_pick_jobs";
    }

    @GetMapping("/teacher/jobs")
    public String showTeacherJobPickPage() {
    return "teacher_pick_jobs";
    }

    @GetMapping ("/organizationInfoPage/{id}/createRequest")
    public String showNewRequestPage() {
        return "create_request";
    }
}