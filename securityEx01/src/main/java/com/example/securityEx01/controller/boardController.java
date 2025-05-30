package com.example.securityEx01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class boardController {

//	@Autowired
//	boardRepository boardRepository;
//
//	@GetMapping("/boardForm")
//	public String getBoardForm() {
//
//		return "boardForm";
//	}
//
//	@PostMapping("/boardForm")
//	public String postBoardForm(boardEntity boardEntity, RedirectAttributes rttr){
//	   boardEntity.setBid("BOARD");
//	   boardEntity b = boardRepository.save(boardEntity);
//	   rttr.addFlashAttribute("board", b);
//
//	    return "redirect:/boardList";
//	}
//	@GetMapping("/boardList")
//	public String getBoardList(Model model) {
//		log.info("boardlist...");
//		List<boardEntity> list = boardRepository.findAll();
//		model.addAttribute("list",list);
//
//		return "boardList";
//	}
//	
//	@GetMapping("/boardDetail")
//	public String boardDetail(@RequestParam("bid")String bid,
//							@RequestParam("title")String title,
//							@RequestParam("content")String content,
//							Model model) {
//		boardEntity result = boardRepository.findByBid(bid);
//		
//		model.addAttribute("board",result);
//		return "boardDetail";
//	}
//	
//	@PostMapping("/update")
//	public String update(boardEntity boardEntity, RedirectAttributes rttr) {
//		boardRepository.save(boardEntity);
//		
//		return "redirect:/boardDetail?bid=" + boardEntity.getBid();
//	}
//	
//	@GetMapping("boardDelete")
//	public String boardDelete(@RequestParam("bid")String bid,
//								RedirectAttributes rttr) {
//		boardRepository.deleteById(bid);
//		
//		return "redirect:/boardList";
//	}

}
