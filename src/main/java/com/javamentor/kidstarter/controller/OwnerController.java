package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
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
        return "owner-kids";
    }

    @RequestMapping("/kids/add")
    public String addKid() {
        return "owner-add-kid";
    }

    @RequestMapping("/teachers")
    public String getTeachers() {
        return "owner-teachers";
    }

    @RequestMapping("/teachers/add")
    public String addTeacher() {
        return "owner-add-teacher";
    }

    @RequestMapping("/active-requests")
    public String getActiveRequests() {
        return "owner-active-requests";
    }

    @RequestMapping("/add-request")
    public String addRequest() {
        return "owner-add-request";
    }
}
