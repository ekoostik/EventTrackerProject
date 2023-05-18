package com.skilldistillery.jobapp.services;

import java.util.List;

import com.skilldistillery.jobapp.entities.User;

public interface UserService {
	
	User update(User user);
	User findByUsername(String username);
	User deactivate(String username);
	List<User> findAll();
	
}
