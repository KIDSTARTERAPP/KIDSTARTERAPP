package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Mentor;

import java.util.List;

public interface MentorService {

    Mentor getMentorById(Long id);

    Mentor addMentor(Mentor mentor);

    List<Mentor> getAllMentors();

    void deleteMentorById(Long id);

    void updateMentor(Mentor mentor);
}
