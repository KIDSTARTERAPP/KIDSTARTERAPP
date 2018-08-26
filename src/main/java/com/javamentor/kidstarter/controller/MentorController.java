package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.service.interfaces.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @GetMapping(value = "/mentor/add")
    public String  getRegistrationMentor(Model model){
        return "createMentor";
    }

    @GetMapping(value = "/mentor/{id}")
    public String  mentorPage(@PathVariable("id") long id, Model model){
        Mentor mentor = mentorService.getMentorById(id);
        model.addAttribute("pointX", mentor.getPointX());
        model.addAttribute("pointY", mentor.getPointY());
        return "mentorPage";
    }

    @GetMapping(value = "/mapPage")
    public String  mapsPage(){
        return "mapPage";
    }
}
