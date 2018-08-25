package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.Teacher;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.TeacherService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestTeacherController {


    static final Logger logger = LoggerFactory.getLogger(RestTeacherController.class);

    private final UserService userService;
    private final RoleService roleService;

    private final TeacherService teacherService;

    @Autowired
    public RestTeacherController(TeacherService teacherService, UserService userService, RoleService roleService) {
        this.teacherService = teacherService;
        this.userService = userService;
        this.roleService = roleService;
    }

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
    public HttpStatus addTeacher(@RequestBody User user) {

        List<Role> roles = new ArrayList<>();
        Role roleUser = roleService.getByName("USER");
        Role roleTeacher = roleService.getByName("TEACHER");
        roles.add(roleUser);
        roles.add(roleTeacher);
        user.setRoles(roles);
        user.setCreateDate(LocalDateTime.now());
        userService.addUser(user);
        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacherService.addTeacher(teacher);
        return HttpStatus.OK;
    }

    @PutMapping("/teacher")
    public ResponseEntity<?> updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
