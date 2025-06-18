package com.example.rest_jwt_ex00_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_jwt_ex00_2.auth.JWTUtil;
import com.example.rest_jwt_ex00_2.dto.LoginDto;
import com.example.rest_jwt_ex00_2.entity.User;
import com.example.rest_jwt_ex00_2.service.UserService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	@Autowired
	private JWTUtil jwtUtil;
    @Autowired
	private UserService userService;   // 직접 구현(패스워드 검증 등)
    
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginDto loginDto){
		System.out.println("login............" + loginDto.getUsername());
		
		User user = userService.login(loginDto.getUsername(), loginDto.getPassword());
		System.out.println("user : " + user);
		
		if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = jwtUtil.createJwt(user);
        System.out.println("token : " + token);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Authorization", "Bearer " + token) // 단일 헤더 추가
                .body(user);
	}
	
}
