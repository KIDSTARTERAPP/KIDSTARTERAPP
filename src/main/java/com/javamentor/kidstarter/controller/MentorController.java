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

    @RequestMapping("/suitable-requests")
    public String getAllRequests() {
        return "suitable-requests";
    }

}
