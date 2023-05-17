package com.skilldistillery.jobapp.services;

import com.skilldistillery.jobapp.entities.User;

public interface AuthService{

	public User register(User user);
	public User getUserByUsername(String username);
	
}
