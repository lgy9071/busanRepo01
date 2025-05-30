package com.example.theater.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class reviewDto {
	private int reid;
    private int pid;
    private String mid;
    private String rcomment;
    private int rating;
    private Date regDate;
    private String showTitle; // 공연 제목 (JOIN용)
    //private String writer;  작성자 이름 또는 mid 그대로 사용할거여서 생략
}