package com.example.rest_jwt_ex00_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_user10")
@Data
public class User {
	@Id
	private String username;
	private String password;
	private String name;
	private String role;
}
