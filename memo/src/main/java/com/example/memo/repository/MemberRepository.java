package com.example.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.memo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    // ID(username) 찾기
    Member findByUsername(String username);

    // username 있는지 찾기
    boolean existsByUsername(String username);
}