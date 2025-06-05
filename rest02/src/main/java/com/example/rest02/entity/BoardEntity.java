package com.example.rest02.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_board3")
@Getter
@Setter
@ToString
public class BoardEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bno;
	private String title;
	private String content;
	private String writer;
//	@Column(name="regdate")
//	private LocalDateTime regDate; //등록
//	@Column(name="moddate")
//	private LocalDateTime modDate; //수정
}
