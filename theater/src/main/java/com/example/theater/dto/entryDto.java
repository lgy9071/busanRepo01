package com.example.theater.dto;

import java.util.Date;

import lombok.Data;

@Data
public class entryDto {

	private int entry_id;
	private int eno;
	private String user_id;
	private Date entry_date;
}
