package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.JobDao;
import com.javamentor.kidstarter.model.Job;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JobDaoImpl extends AbstractDao<Long, Job> implements JobDao {
}
