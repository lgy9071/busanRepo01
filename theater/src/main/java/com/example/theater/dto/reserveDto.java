package com.example.theater.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class reserveDto {
		private int rid;
		private int pid;
	    private String mid;
	    private Date rdate;
	    private String title; //join용
	    private String showTitle; 
}
