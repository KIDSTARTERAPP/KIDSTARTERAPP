package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.Job;

import java.util.List;

public interface JobService {

    Job getJobById(Long id);

    Job addJob(Job job);

    List<Job> getAllJob();

    void deleteJobById(Long id);

    void updateJob(Job job);
}
