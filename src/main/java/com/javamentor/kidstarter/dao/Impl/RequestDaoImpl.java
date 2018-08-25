package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.RequestDao;
import com.javamentor.kidstarter.model.Request;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RequestDaoImpl extends AbstractDao<Long,Request> implements RequestDao {
}
