package com.example.demo2.repository;

import com.example.demo2.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestRepository {

    @Autowired
    MemberRepository memberRepository;

    //@Test
    void countMemberTestNative(){
        long count = memberRepository.countAllMembersNative();
        assertEquals(4, count);
    }

    //@Test
    void countMemberTestJpql(){
        long count = memberRepository.countAllMembers();
        assertEquals(4, count);
    }

    //@Test
    void countMemberTest2(){
        long count = memberRepository.countBy();

        assertEquals(4, count);
    }

    //@Test
    void countMemberTest(){
        long count = memberRepository.count();
        assertEquals(4, count);
    }

    //@Test
    void insertMemberDummies(){
        IntStream.rangeClosed(0, 3).forEach(i ->{
            Member member = Member.builder()
                    .username("user" + i)
                    .password("1234" + i)
                    .name("user" + i)
                    .phone("010-1234-123" + i)
                    .build();
            memberRepository.save(member);
        });
    }

}
