package com.example.demo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_board2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY) //'보통'의 경우 lazy 사용('나중에' 연관 정보 검색해온다) //두 단계로 나눠서 //many쪽에 관계 설정해야함
    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member; //기본 생성자는 반드시 있어야함

}
