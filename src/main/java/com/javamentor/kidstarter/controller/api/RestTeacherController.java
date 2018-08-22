package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Teacher;
import com.javamentor.kidstarter.service.interfaces.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestTeacherController {


    static final Logger logger = LoggerFactory.getLogger(RestTeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> listAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @DeleteMapping("/teacher/{id}")
    public HttpStatus deleteTeacherById(@PathVariable("id") long id) {
        teacherService.deleteTeacherById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/teacher")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PutMapping("/teacher")
    public ResponseEntity<?>  updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
