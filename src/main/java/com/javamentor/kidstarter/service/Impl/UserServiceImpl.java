package com.javamentor.kidstarter.service.Impl;


import com.javamentor.kidstarter.dao.interfaces.UserDao;
import com.javamentor.kidstarter.model.User;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDAO;


	@Override
	public User getUserById(Long id) {
		return null;
	}

	@Override
	public void addUser(User user) {

	}

	@Override
	public List<User> getAllUser() {
		return null;
	}

	@Override
	public void deleteUserById(Long id) {

	}

	@Override
	public void updateUser(User user) {

	}
}
