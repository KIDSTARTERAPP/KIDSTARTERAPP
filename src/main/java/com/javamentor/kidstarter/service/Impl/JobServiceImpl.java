package com.javamentor.kidstarter.service.Impl;


import com.javamentor.kidstarter.dao.interfaces.JobDao;
import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.service.interfaces.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {


	private JobDao jobDao;

    @Autowired
	public JobServiceImpl(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	public Job getJobById(Long id) {
		return jobDao.getByKey(id);
	}

	public Job addJob(Job job) {
		jobDao.persist(job);
		return job;
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
