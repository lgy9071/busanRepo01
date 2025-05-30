package com.example.theater.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class eventDto {

	 private int eno;
	 private String title;
	 private String content;
	 private Date start_date;
	 private Date end_date;
	 
}

