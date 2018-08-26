package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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

    @Autowired
    RoleService roleService;

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

    @GetMapping("/tagPage")
    public String showTagsPage() {
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

    @GetMapping("/organization/teachers/add")
    public String createTeacher(){
        return "createTeacher";
    }
    @GetMapping("/organization/teachers")
    public String getAllTeachers() {
        return "getAllTeachers";
    }
}