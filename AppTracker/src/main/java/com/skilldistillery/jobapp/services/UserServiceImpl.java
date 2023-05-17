package com.skilldistillery.jobapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapp.entities.User;
import com.skilldistillery.jobapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User update(User user) {
		User toUpdate = userRepo.findByUsername(user.getUsername());
		if (toUpdate != null) {
			if (user.getFirstName() != null) {
				toUpdate.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				toUpdate.setLastName(user.getLastName());
			}
			if (user.getPhoto() != null) {
				toUpdate.setPhoto(user.getPhoto());
			}
			if (user.getEnabled() != null) {
				toUpdate.setEnabled(false);
			}
			if (user.getPassword() != null) {
				toUpdate.setPassword(user.getPassword());
				String encrypted = encoder.encode(user.getPassword());
				user.setPassword(encrypted);
			}
			userRepo.saveAndFlush(toUpdate);
			return toUpdate;

		}
		return null;
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User deactivate(String username) {
		User user = userRepo.findByUsername(username);
		user.setEnabled(false);
		return userRepo.saveAndFlush(user);

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
