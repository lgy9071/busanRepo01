package com.example.theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.theater.dao.IMemberDao;
import com.example.theater.dto.memberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class memberController {
	
	@Autowired
	private IMemberDao dao;

	@GetMapping("/")
	public String root() {
		System.out.println("root...");

		return "index";
	}
	
	//로그인==============================
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw")String pw,
						HttpSession session, Model model) {
		memberDto member = dao.login(id,pw);
		
		if(member != null) {
			session.setAttribute("loginId", member.getId());
			session.setAttribute("loginName", member.getName());
			return "index";
		}else {
			model.addAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다.");
			return "login";
		}	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 회원가입============================
	@GetMapping("/regist")
	public String showRegistPage() {
		return "regist";
	}

	// id 체크용===========================
	@GetMapping("/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {
		System.out.println("중복 체크할 ID: " + id);

		// select 메서드를 사용하여 중복 확인
		int count = dao.selectid(id);

		if (count > 0) {
			return "이미 사용 중인 ID입니다.";
		} else {
			return "사용 가능한 ID 입니다.";
		}
	}

	// 회원 리스트===========================
	@GetMapping("/list")
	public String showListPage(Model model) {
		model.addAttribute("members", dao.getList());

		return "memberList";
	}

	// 회원 정보 삽입 post
	@PostMapping("/regist2")
	@ResponseBody
	public String insert(memberDto member) {
		try {
			System.out.println("insert param : " + member);
			dao.insertMember(member);
			return "회원가입 성공!"; // AJAX가 읽을 수 있게 문자열 반환
		} catch (Exception e) {
			e.printStackTrace();
			return "회원가입 실패.."; 
		}

	}

}
