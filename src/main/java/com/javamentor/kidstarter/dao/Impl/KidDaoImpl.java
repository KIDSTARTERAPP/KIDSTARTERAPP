package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.KidDao;
import com.javamentor.kidstarter.model.user.Kid;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class KidDaoImpl extends AbstractDao<Long, Kid> implements KidDao {
}
