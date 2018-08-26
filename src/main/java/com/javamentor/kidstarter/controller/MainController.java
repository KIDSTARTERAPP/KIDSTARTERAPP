package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import com.javamentor.kidstarter.service.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private JobService jobService;

    @Autowired
    private TagService tagService;

    @Autowired
    OrganizationService organizationService;

    @RequestMapping
    public String showMain() {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration() {
        return "registration";
    }

    @RequestMapping("/profile") // общая для всех страница, заполняется которая из логина
    public String getUserProfile() {
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

    @GetMapping("/organization/kids/add")
    public String createKidPage() {
        return "createKid";
    }

    @GetMapping("/organization/kids")
    public String getAllKids() {
        return "getAllKids";
    }

    @GetMapping("/organization/kids/{id}")
    public String showKidEdit(@PathVariable("id") String id) {
        return "editKid";
    }

    @GetMapping("/organization/teacher/add")
    public String createTeacher() {
        return "createTeacher";
    }

    @GetMapping("/organization/teacher/{id}")
    public String editTeacher(@PathVariable("id") String id) {
        return "editTeacher";
    }

    @GetMapping("/organization/teachers")
    public String getAllTeachers() {
        return "allTeachers";
    }
}