package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.service.interfaces.KidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestKidController {

    static final Logger logger = LoggerFactory.getLogger(RestKidController.class);

    @Autowired
    private KidService kidService;

    @GetMapping("/kid/{id}")
    public ResponseEntity<?> getKidId(@PathVariable("id") long id) {
        Kid kid = kidService.getKidById(id);
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }

    @GetMapping("/kids")
    public ResponseEntity<List<Kid>> listAllKids() {
        List<Kid> kid = kidService.getAllKids();
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }

    @DeleteMapping("/kid/{id}")
    public HttpStatus deleteKidById(@PathVariable("id") long id) {
        kidService.deleteKidById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/kid")
    public ResponseEntity<?> addKid(@RequestBody Kid kid) {
        kidService.addKid(kid);
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }

    @PutMapping("/kid")
    public ResponseEntity<?>  updateKid(@ModelAttribute("kid") Kid kid) {
        kidService.updateKid(kid);
        return new ResponseEntity<>(kid, HttpStatus.OK);
    }
}
