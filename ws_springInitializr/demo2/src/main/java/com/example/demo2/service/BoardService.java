package com.example.demo2.service;

import com.example.demo2.entity.Board;
import com.example.demo2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getBoardList(){
        List<Board> list = boardRepository.findAll();

        return list;

    }
}
