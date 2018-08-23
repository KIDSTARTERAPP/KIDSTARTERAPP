package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Autowired
    private JobService jobService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/main")
    public String showMain(Model model) {
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

    @GetMapping("/jobPage")
    public String showJobPage() {
//        model.addAttribute("tags", jobService.getAllJob());
        return "jobPage";
    }

    @GetMapping("/createUser")
    public String createUserPage() {
        return "createUser";
    }

    @GetMapping("/tagPage")
    public String showTagsPage(Model model) {
        model.addAttribute("tags", tagService.getAllTag());
        return "tagPage";
    }
}