package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RestMentorController {

    private final MentorService mentorService;

    @Autowired
    public RestMentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping(value = "/mentor/add")
    public ResponseEntity registrationMentor(@RequestBody Mentor mentor) {

        User userFromSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mentor.setUser(userFromSession);
        mentorService.addMentor(mentor);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
