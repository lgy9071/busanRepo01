package com.example.securityEx04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityEx04.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);

	
}
