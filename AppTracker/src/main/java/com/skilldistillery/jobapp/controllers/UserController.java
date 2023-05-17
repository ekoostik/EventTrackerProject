package com.skilldistillery.jobapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobapp.entities.User;
import com.skilldistillery.jobapp.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class UserController {
	
	@Autowired
	private UserService userSrvc;
	
	
	@GetMapping("users")
	public List<User> findAll(){
		return userSrvc.findAll();
		
	}
	@GetMapping("user")
	public User find(Principal principal, HttpServletResponse resp) {
		User user = new User();
		try {
			 user= userSrvc.findByUsername(principal.getName());
			if (user == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			user = null;
		}
		return user;
		
	}
	
	@PutMapping("user")
	public User update(Principal principal, @RequestBody User user, HttpServletResponse resp) {
		
		try {
			user= userSrvc.update(user);
			if (user == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			user = null;
		}
		return user;
		
	}
	
	
	
	
	
	
	
	
	

}
