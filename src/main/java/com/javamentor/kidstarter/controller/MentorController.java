package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @RequestMapping("/profile")
    public String getMentorProfile() {
        return "mentor-page";
    }

    @RequestMapping("/my-requests")
    public String getMyRequests() {
        return "my-requests";
    }

    @GetMapping("/mentor/requests")
    public String showAvailableRequests() {
        return "mentor_requests";
    }

    @GetMapping("/mentor/activerequests")
    public String showMentorActiveRequests() {
        return "mentor_active_requests";
    }


    @RequestMapping("/suitable-requests")
    public String getAllRequests() {
        return "suitable-requests";
    }

}
