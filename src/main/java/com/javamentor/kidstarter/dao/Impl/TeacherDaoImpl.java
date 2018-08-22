package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.TeacherDao;
import com.javamentor.kidstarter.model.user.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TeacherDaoImpl extends AbstractDao<Long, Teacher> implements TeacherDao {
}
