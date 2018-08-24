package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.TeacherDao;
import com.javamentor.kidstarter.model.user.Teacher;
import com.javamentor.kidstarter.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDao.getByKey(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        teacherDao.persist(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAll();
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherDao.deleteByKey(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public Teacher getUserTeacherById(Long id) {
        return teacherDao.getUserTeacherById(id);
    }
}
