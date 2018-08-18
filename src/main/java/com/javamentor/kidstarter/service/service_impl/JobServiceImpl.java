package com.javamentor.kidstarter.service.service_impl;



import com.javamentor.kidstarter.dao_abstract.JobDao;
import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.service.service_abstract.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;

	public Job getJobById(Long id) {
		return jobDao.getByKey(id);
	}

	public void addJob(Job job) {
		jobDao.persist(job);
	}

	public List<Job> getAllJob() {
		return jobDao.getAll();
	}

	public void deleteJobById(Long id) {
		jobDao.deleteByKey(id);
	}

	public void updateJob(Job job) {
		jobDao.update(job);
	}

}
