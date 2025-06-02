package com.example.securityEx04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityEx04.dto.UserDto;

@Controller
public class MainController {

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("msg", "hello~");
		return "index";
	}
	
	
	
}
