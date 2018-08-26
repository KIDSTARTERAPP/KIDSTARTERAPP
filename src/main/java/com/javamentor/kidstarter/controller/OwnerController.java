package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organization")
public class OwnerController {

    @RequestMapping
    public String getOwnerPage() {
        return "owner-page";
    }

    @RequestMapping("/profile")
    public String getOwnerProfile() {
        return "owner-page";
    }

    @RequestMapping("/kids")
    public String getKids() {
        return "getAllKids";
    }

    @RequestMapping("/kids/add-kid")
    public String addKid() {
        return "createKid";
    }

    @RequestMapping("/teachers")
    public String getTeachers() {
        return "owner-teachers";
    }

    @RequestMapping("/teachers/add-teacher")
    public String addTeacher() {
        return "createTeacher";
    }

    @RequestMapping("/active-requests")
    public String getActiveRequests() {
        return "organization_requests";
    }

    @RequestMapping("/requests/add-request")
    public String addRequest() {
        return "create_request";
    }

    @GetMapping("/requests")
    public String showOrganizationRequests() {
        return "organization_requests";
    }
}
