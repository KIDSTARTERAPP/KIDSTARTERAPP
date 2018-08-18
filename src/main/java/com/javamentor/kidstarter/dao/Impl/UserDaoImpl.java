package com.javamentor.kidstarter.dao.Impl;


import com.javamentor.kidstarter.dao.interfaces.UserDao;
import com.javamentor.kidstarter.model.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    public User  getByLogin(String login){
        return  (User) entityManager.createQuery("SELECT u from  User u WHERE u.login = :login",User.class).setParameter("login",login).getSingleResult();
    }
}
