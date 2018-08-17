package com.javamentor.kidstarter.service.Impl;


import com.javamentor.kidstarter.dao.interfaces.UserDao;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.security.config.PassEncode;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private  final UserDao userDAO;
	@Autowired
	private PassEncode passwordEncoder;

	@Autowired
	public UserServiceImpl(UserDao userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public User getUserById(Long id) {
		return userDAO.getByKey(id);
	}

	@Override
	public void addUser(User user) {
		user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
		userDAO.persist(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.getAll();
	}

	@Override
	public void deleteUserById(Long id) {
		userDAO.deleteByKey(id);
	}

	@Override
	public void updateUser(User user) {
		user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
		userDAO.update(user);
	}

	@Override
	public User getByLogin(String login) {
		return userDAO.getByLogin(login);
	}
}
