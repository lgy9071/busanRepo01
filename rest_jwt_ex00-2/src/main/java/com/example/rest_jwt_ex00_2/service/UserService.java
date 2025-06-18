package com.example.rest_jwt_ex00_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rest_jwt_ex00_2.entity.User;
import com.example.rest_jwt_ex00_2.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User login(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		
		return user;
	}
	
	
}
