package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.dto.boardDto;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;

@RestController
@RequestMapping("/api/board-post")
public class PostBoardController {

	@Autowired
	private BoardService boardService;
	
	//http://localhost:8090/api/board-post/board
	@PostMapping("/board") //board 자료를 post 할게
	public ResponseEntity<BoardEntity> postBoard(@RequestBody boardDto boardDto){
		
		BoardEntity result = boardService.registBoard(boardDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}
