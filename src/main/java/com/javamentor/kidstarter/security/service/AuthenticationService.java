package com.javamentor.kidstarter.security.service;


import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public AuthenticationService(UserService userService) {
		this.userService = userService;
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userService.getByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException("Login " + login + " not found");
		}
		return user;
	}
}
