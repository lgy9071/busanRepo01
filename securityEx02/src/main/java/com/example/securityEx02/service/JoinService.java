package com.example.securityEx02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityEx02.dto.UserDto;
import com.example.securityEx02.entity.User;
import com.example.securityEx02.repository.UserRepository;

@Service
public class JoinService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User regist(UserDto userDto) {
		//0. 서비스단에서 컨트롤러에서 전달한 파라미터 받음.
		
		//1. 파라미터로 넘어온 password 암호화 (newPw=암호화된 Pw)
		String newPw = bCryptPasswordEncoder.encode(userDto.getPassword());
		
		//2. Dto -> Entity로 바꾸는 작업
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(newPw);
		user.setName(userDto.getName());
		
		//3. role 정보저장 (username = 'admin' -> role = 'ROLE_ADMIN' 아니면 'ROLE_MEMBER')
		if(userDto.getUsername().equals("admin")) {
			user.setRole("ROLE_ADMIN");
		}else {
			user.setRole("ROLE_MEMBER");
		}
		
		// DB에 회원정보 저장.
		return userRepository.save(user);
	}
}
