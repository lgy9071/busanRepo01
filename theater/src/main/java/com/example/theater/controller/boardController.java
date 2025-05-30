package com.example.theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.theater.dao.IBoardDao;
import com.example.theater.dto.boardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class boardController {

	@Autowired
	private IBoardDao dao;

	@GetMapping("/boardList")
	public String list(Model model) {
		model.addAttribute("list", dao.getList());
		return "boardList";
	}

	@GetMapping("/boardWrite")
	public String writeForm() {
		return "boardWrite";
	}

	@PostMapping("/boardWrite")
	public String boardWrite(boardDto boardDto, HttpSession session, HttpServletRequest request) {
	    String userId = (String) session.getAttribute("userId");
	    boardDto.setWriter(userId);  // 로그인한 사용자로 작성자 설정
	    dao.insert(boardDto); // 또는 DAO 호출
	    return "redirect:/boardList";
	}

	@GetMapping("/boardDetail")
	public String detail(@RequestParam("bno") int bno, Model model) {
		boardDto board = dao.getBoard(bno);
		model.addAttribute("board", board); //("board", dao.getBoard(bno));
		return "boardDetail";
	}

	@PostMapping("/boardUpdate")
	public String update(@ModelAttribute boardDto dto) {
		dao.updateBoard(dto);
		return "redirect:/boardList";
	}

	@PostMapping("/boardDelete")
	public String delete(@RequestParam("bno") int bno) { //@PathVariable
		dao.deleteBoard(bno);
		return "redirect:/boardList";
	}
}
