package com.example.demo2.repository;

import com.example.demo2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //entity 놀이터 = 영속성 contest

    @Query("SELECT b FROM Board b JOIN FETCH b.member") // board: entity의 board
    public List<Board> getBoardListWithMember(); //fetch 전략을 이걸로 쓰겠다
} // 메서드 이름이 그대로 쿼리로 변환되는 '쿼리 메서드'로 잘 찾을 수 있다
