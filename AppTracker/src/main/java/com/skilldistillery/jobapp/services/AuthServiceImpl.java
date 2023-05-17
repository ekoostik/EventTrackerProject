
package com.skilldistillery.jobapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.User;
import com.skilldistillery.jobapp.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(User user) {
		//FIXME
		String encrypted = encoder.encode(user.getPassword());
		user.setPassword(encrypted);
//		// TODO Auto-generated method stub
		user.setEnabled(true);
		user.setRole("user");
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

}
