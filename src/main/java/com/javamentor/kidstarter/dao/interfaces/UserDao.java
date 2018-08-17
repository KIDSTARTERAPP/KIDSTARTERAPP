package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.user.User;


public interface UserDao extends GenericDao<Long , User> {

    User getByLogin(String login);
}