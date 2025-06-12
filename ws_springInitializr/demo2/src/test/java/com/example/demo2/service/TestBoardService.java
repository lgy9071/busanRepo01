package com.example.demo2.service;

import com.example.demo2.entity.Board;
import com.example.demo2.entity.Member;
import com.example.demo2.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class TestBoardService {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void testGetBoardListFetch(){
        List<Board> list = boardRepository.getBoardListWithMember();
        for(Board board : list){
            System.out.println(board.getTitle() + " | " + board.getMember().getUsername());
        }
    }

    //@Test
    @Transactional //논리적인 일의 단위
    public void testGetBoard(){
        List<Board> list = boardRepository.findAll();

        for(Board board : list){
            System.out.println(board.getTitle() + " | " + board.getMember().getUsername());
        }
    }

    //@Test
    public void insertBoardDummies(){

        Member member = new Member();
        member.setMember_id(1);

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Board board = Board.builder()
                    .title("test title " + i)
                    .content("test content..." + i)
                    .member(member)
                    .build();
            boardRepository.save(board);
        });
    }

}
