package com.example.rest_jwt_ex00_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@GetMapping("/mypage")
	public @ResponseBody String mypage() {
		
		return "mypage";
	}
}
