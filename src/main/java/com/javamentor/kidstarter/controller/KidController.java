package com.javamentor.kidstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KidController {

    @GetMapping("/kid")
    public String showKidPage() {
        return "kid_page";
    }

    @GetMapping("/kid/jobs")
    public String showKidJobPickPage() {
        return "kid_pick_jobs";
    }
}