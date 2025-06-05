package com.example.rest02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest02.dto.boardDto;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	//게시글 등록 업무(기능=함수)  - registBoard : 준비- 게시글, 결과 -?
	public BoardEntity registBoard(boardDto boardDto){ //레이어 간의 이동은 dto
		
		//DTO -> Entity 변환작업
		BoardEntity boardEntity = new BoardEntity();

		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setWriter(boardDto.getWriter());
		boardEntity.setContent(boardDto.getContent());
		
		BoardEntity result = boardRepository.save(boardEntity);
		
		return result;
	}
	
	//게시글 조회업무 - getBoardByBno : 준비 - bno, 결과 - BoardEntity
	public BoardEntity getBoardByBno(Integer bno) {
//		Optional<BoardEntity> result = boardRepository.findById(bno);
//		BoardEntity boardEntity = result.get();
		BoardEntity boardEntity = boardRepository.findByBno(bno);
		return boardEntity;
	}
	
	//게시글 수정 업무 - updateBoard : 준비 - 수정된 게시글, 결과 - ? > bno 값이 있다면 수정 처리
	public BoardEntity updateBoard(boardDto boardDto) {
		//DTO -> Entity 변환작업
		BoardEntity boardEntity = new BoardEntity();

		boardEntity.setBno(boardDto.getBno());
		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setWriter(boardDto.getWriter());
		boardEntity.setContent(boardDto.getContent());
				
		BoardEntity result = boardRepository.save(boardEntity);
		
		return result;
		
	}
	
	// 게시글 삭제 업무 - deleteBoard : 준비 - bno, 결과 : ?
	public void deleteBoard(Integer bno) {
		boardRepository.deleteById(bno);
	}
	
	
}
