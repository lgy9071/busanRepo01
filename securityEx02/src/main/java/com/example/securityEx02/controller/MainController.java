package com.example.securityEx02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.securityEx02.dto.UserDto;
import com.example.securityEx02.entity.User;
import com.example.securityEx02.service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	private JoinService joinService;	
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/regMember")
	public String regMember() {
		return "registForm";
	}
	
	@PostMapping("/regist")
	public @ResponseBody String regist(UserDto userDto) {
		log.info("userDto: " + userDto);
		//파라미터 받은거 서비스로 전달 (서비스에서 회원가입 처리를 할 거임)
		User result = joinService.regist(userDto);
		if(result != null) {
			return "회원가입 완료";
		} else {
			return "회원가입 실패";
		}
	}
	
	@GetMapping("/login")
		public String loginForm() {
			return "loginForm";
		}
	
	@GetMapping("/fail")
	public String fail() {
		return "fail";
	}
}
