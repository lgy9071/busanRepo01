package com.example.demo2.repository;

import com.example.demo2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    //기본 CRUD
    //INSERT/UPDATE : save( ), SELECT : find~( ), DELETE : delete~( )
    //1.
    //long count = memberRepository.count();
    //2.
    long countBy();

    //3. @Query 어노테이션 사용
    @Query("SELECT COUNT(m) FROM Member m")
    long countAllMembers();

    //4. Native Query 사용
    @Query(value = "SELECT COUNT(*) FROM tbl_member2", nativeQuery = true)
    long countAllMembersNative();
}
