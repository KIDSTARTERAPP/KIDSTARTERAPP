package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.interfaces.*;

import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import com.javamentor.kidstarter.service.interfaces.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private OrganizationService organizationService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;


    @GetMapping
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
        return "create-organization";
    }

    @GetMapping("/editJob/{id}")
    public String showEditJob(@PathVariable("id") Long id) {
        return "editJob";
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

    @GetMapping("/organization/teachers/add")
    public String createTeacher() {
        return "createTeacher";
    }

    @GetMapping("/organization/teachers")
    public String getAllTeachers() {
        return "getAllTeachers";
    }

    @GetMapping("/main/profile/{id}")//profile
    public String showProfile(@PathVariable("id") String id) {
        return "profile";
    }


    /**------------------------------Organization------------------------------**/
    @GetMapping("/organization/{id_org}/kids")
    public String getAllKids(@PathVariable("id_org") long id_org, Model model) {
        model.addAttribute("id_org", id_org);
        return "getAllKids";
    }
    @GetMapping("/organization/{id_org}/kids/create")
    public String createKidPage(@PathVariable("id_org") String id_org, Model model) {
        model.addAttribute("id_org", id_org);
        return "createKid";
    }
    @GetMapping("/organization/{id_org}/kids/{id_kid}")
    public String showKidEdit(@PathVariable("id_org") long id_org, @PathVariable("id_kid") long id_kid, Model model) {
        model.addAttribute("id_org", id_org);
        model.addAttribute("id_kid", id_kid);
        return "editKid";
    }
    /**------------------------------------------------------------------------**/

}