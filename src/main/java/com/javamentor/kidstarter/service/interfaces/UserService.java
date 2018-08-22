package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.User;

import java.util.List;


public interface UserService {

    User getUserById(Long id);

    User addUser(User user);

    List<User> getAllUser();

    void deleteUserById(Long id);

    void updateUser(User user);

    User getByLogin(String login);
}
