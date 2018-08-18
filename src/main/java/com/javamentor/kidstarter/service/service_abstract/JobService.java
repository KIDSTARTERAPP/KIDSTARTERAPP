package com.javamentor.kidstarter.service.service_abstract;


import com.javamentor.kidstarter.model.Job;

import java.util.List;

public interface JobService {

	Job getJobById(Long id);
	void addJob(Job job);
	List<Job> getAllJob();
	void deleteJobById(Long id);
	void updateJob(Job job);
}
