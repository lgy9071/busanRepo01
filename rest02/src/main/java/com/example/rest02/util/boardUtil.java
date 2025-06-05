package com.example.rest02.util;

import com.example.rest02.dto.boardDto;
import com.example.rest02.entity.BoardEntity;

public class boardUtil {

	public boardDto toDto(BoardEntity boardEntity) {
		
		boardDto boardDto = new boardDto();
		
		boardDto.setTitle(boardEntity.getTitle());
		boardDto.setWriter(boardEntity.getWriter());
		boardDto.setContent(boardEntity.getContent());
		
		return boardDto;
	}
	
	public BoardEntity toEntity(boardDto boardDto){ 
		
		BoardEntity boardEntity = new BoardEntity();

		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setWriter(boardDto.getWriter());
		boardEntity.setContent(boardDto.getContent());
		
		return boardEntity;
	}
	
}
