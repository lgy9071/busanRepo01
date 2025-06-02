package com.example.securityEx04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityEx04.dto.UserDto;
import com.example.securityEx04.entity.User;
import com.example.securityEx04.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JoinService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private UserRepository userRepository;
	
	public JoinService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User regist(UserDto userDto) {
		User entity = new User();
		entity.setUsername(userDto.getUsername());
		String newPW = bCryptPasswordEncoder.encode(userDto.getPassword()); //패스워드 암호화
		entity.setPassword(newPW);
		entity.setName(userDto.getName());
		
		if(userDto.getUsername().equals("admin")) {
			entity.setRole("ROLE_ADMIN");
		}else {
			entity.setRole("ROLE_MEMBER");
		}
		
		log.info(entity.toString());
		
		return userRepository.save(entity);
	}
	
}
