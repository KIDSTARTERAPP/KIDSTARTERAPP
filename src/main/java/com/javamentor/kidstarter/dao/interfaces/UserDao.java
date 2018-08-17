package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.User;


public interface UserDao extends GenericDao<Long , User> {

    User getByLogin(String login);
}