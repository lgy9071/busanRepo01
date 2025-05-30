package com.example.theater.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class performanceDto {
	private int pid;
	private String title;
	private String description;
	private String status;
	private Date reg_date;
	private String showTitle;
}
