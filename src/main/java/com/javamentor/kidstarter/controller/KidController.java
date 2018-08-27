package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kid")
public class KidController {

    @GetMapping("/jobs")
    public String showKidWishList() {
        return "kid_page";
    }

    @GetMapping("/pick-jobs")
    public String showKidPickJobPage() {
        return "kid_pick_jobs";
    }
}
