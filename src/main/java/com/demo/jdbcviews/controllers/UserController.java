package com.demo.jdbcviews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jdbcviews.models.User;
import com.demo.jdbcviews.models.UserView;
import com.demo.jdbcviews.repositories.UserRepository;
import com.demo.jdbcviews.repositories.UserViewRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserViewRepository userViewRepository;
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userRepository.getUserById(id);
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	@GetMapping("/view/{id}")
	public UserView getUserViewById(@PathVariable Long id) {
		userViewRepository.findById(id).get();
		return userViewRepository.findById(id).get();
	}
	
	@GetMapping("/view")
	public List<UserView> getUserViews() {
		userViewRepository.findAll();
		return userViewRepository.findAll();
	}


}
