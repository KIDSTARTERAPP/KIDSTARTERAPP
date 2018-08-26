package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.service.interfaces.MentorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestMentorController {

    static final Logger logger = LoggerFactory.getLogger(RestMentorController.class);

    @Autowired
    private MentorService mentorService;

    @GetMapping("/mentor/{id}")
    public ResponseEntity<?> getMentorById(@PathVariable("id") long id, Model model) {
        model.addAttribute("id_model", id);
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
        mentorService.addMentor(mentor);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @PutMapping("/mentor")
    public ResponseEntity<?>  updateMentor(@ModelAttribute("mentor") Mentor mentor) {
        mentorService.updateMentor(mentor);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }
}
