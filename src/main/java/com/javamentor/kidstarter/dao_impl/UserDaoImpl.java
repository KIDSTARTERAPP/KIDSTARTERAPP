package com.javamentor.kidstarter.dao_impl;



import com.javamentor.kidstarter.dao_abstract.UserDao;
import com.javamentor.kidstarter.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {
}
