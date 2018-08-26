package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.MentorService;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestMentorController {

    static final Logger logger = LoggerFactory.getLogger(RestMentorController.class);

    private final MentorService mentorService;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RestMentorController(MentorService mentorService, UserService userService, RoleService roleService) {
        this.mentorService = mentorService;
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/mentor/{id}")
    public ResponseEntity<?> getMentorById(@PathVariable("id") long id) {
        Mentor mentor = mentorService.getMentorById(id);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @GetMapping("/mentors")
    public ResponseEntity<List<Mentor>> listAllMentors() {
        List<Mentor> mentor = mentorService.getAllMentors();
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @DeleteMapping("/mentor/{id}")
    public HttpStatus deleteMentorById(@PathVariable("id") long id) {
        mentorService.deleteMentorById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/mentor")
    public ResponseEntity<?> addMentor(@RequestBody Mentor mentor) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Mentor currentMentor = mentorService.getMentorById(principal.getId());
        if (currentMentor == null) {
            Role role = roleService.getByName("MENTOR");
            principal.getRoles().add(role);
            userService.updateUser(principal);
            mentor.setUser(principal);
            currentMentor = mentorService.addMentor(mentor);
        }
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return new ResponseEntity<>(currentMentor, HttpStatus.OK);
    }

    @PutMapping("/mentor")
    public ResponseEntity<?> updateMentor(@ModelAttribute("mentor") Mentor mentor) {
        mentorService.updateMentor(mentor);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }
}
