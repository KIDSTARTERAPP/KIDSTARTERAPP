package com.javamentor.kidstarter.dao_impl;



import com.javamentor.kidstarter.dao_abstract.JobDao;
import com.javamentor.kidstarter.model.Job;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class JobDaoImpl extends AbstractDao<Long, Job> implements JobDao {
}
