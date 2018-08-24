package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.TeacherDao;
import com.javamentor.kidstarter.model.user.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TeacherDaoImpl extends AbstractDao<Long, Teacher> implements TeacherDao {

    @Override
    public Teacher getUserTeacherById(Long id) {
        return entityManager.createQuery("SELECT o from Teacher o WHERE o.user.id = :id", Teacher.class).setParameter("id",id).getSingleResult();
    }
}
