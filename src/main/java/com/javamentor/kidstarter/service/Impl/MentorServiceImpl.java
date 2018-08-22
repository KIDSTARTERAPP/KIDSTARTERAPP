package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.MentorDao;
import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.service.interfaces.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    private MentorDao mentorDao;

    @Autowired
    public MentorServiceImpl(MentorDao mentorDao) {
        this.mentorDao = mentorDao;
    }

    @Override
    public Mentor getMentorById(Long id) {
        return mentorDao.getByKey(id);
    }

    @Override
    public Mentor addMentor(Mentor mentor) {
        mentorDao.persist(mentor);
        return mentor;
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorDao.getAll();
    }

    @Override
    public void deleteMentorById(Long id) {
        mentorDao.deleteByKey(id);
    }

    @Override
    public void updateMentor(Mentor mentor) {
        mentorDao.update(mentor);
    }
}
