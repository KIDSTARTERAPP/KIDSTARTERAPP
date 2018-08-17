package com.javamentor.kidstarter.service.service_impl;



import com.javamentor.kidstarter.dao_abstract.UserDao;
import com.javamentor.kidstarter.model.User;
import com.javamentor.kidstarter.service.service_abstract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDAO;

	public User getUserById(Long id) {
		return userDAO.getByKey(id);
	}

	public void addUser(User user) {
		userDAO.persist(user);
	}

	public List<User> getAllUser() {
		return userDAO.getAll();
	}

	public void deleteUserById(Long id) {
		 userDAO.deleteByKey(id);
	}

	public void updateUser(User user) {
		 userDAO.update(user);
	}

}
