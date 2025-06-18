package com.example.rest_jwt_ex00_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest_jwt_ex00_2.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
