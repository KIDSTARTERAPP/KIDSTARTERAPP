package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Mentor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MentorService {

    Mentor getMentorById(Long id);

    Mentor addMentor(Mentor mentor);

    List<Mentor> getAllMentors();

    void deleteMentorById(Long id);

    void updateMentor(Mentor mentor);

    Mentor getUserMentorById(Long id);
}
