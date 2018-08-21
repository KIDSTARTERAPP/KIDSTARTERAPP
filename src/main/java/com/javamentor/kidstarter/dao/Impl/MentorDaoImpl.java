package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.MentorDao;
import com.javamentor.kidstarter.model.user.Mentor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MentorDaoImpl extends AbstractDao<Long, Mentor> implements MentorDao {
}
