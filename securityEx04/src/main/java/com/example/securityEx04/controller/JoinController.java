package com.example.securityEx04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityEx04.dto.UserDto;
import com.example.securityEx04.entity.User;
import com.example.securityEx04.service.JoinService;

@Controller
public class JoinController {

	private JoinService joinService;
	
	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}
	
	@GetMapping("/regist")
	public String registForm() {
		
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String regist(UserDto userDto) {
		User result = joinService.regist(userDto);
		if(result != null) {
			return "redirect:/login";
		}
		
		
		return "redirect:/regist";
	}
}
