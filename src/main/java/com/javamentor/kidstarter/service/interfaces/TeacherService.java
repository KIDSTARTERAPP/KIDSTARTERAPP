package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Teacher getTeacherById(Long id);
    Teacher addTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    void deleteTeacherById(Long id);
    void updateTeacher(Teacher teacher);
}
