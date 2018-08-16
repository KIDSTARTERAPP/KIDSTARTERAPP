package com.javamentor.kidstarter.dao.Impl;


import com.javamentor.kidstarter.dao.interfaces.UserDao;
import com.javamentor.kidstarter.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

}
