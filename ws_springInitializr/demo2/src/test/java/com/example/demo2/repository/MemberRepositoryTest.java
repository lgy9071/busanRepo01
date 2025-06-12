package com.example.demo2.repository;

import com.example.demo2.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //@Test
    void testInsertDummies() {
        IntStream.rangeClosed(0, 3).forEach(i -> {
            Member member = Member.builder()
                    .username("user" + i)
                    .password("1234" + i)
                    .name("user" + i)
                    .phone("010-1111-222" + i)
                    .build();
            memberRepository.save(member);
        });
    }

    //@Test
    void testDelete() {
        Integer member_id = 2;
        memberRepository.deleteById(member_id);
    }

    //@Test
    //@Transactional
    void testUpdate() {
        Member member = memberRepository.findById(1).orElseThrow();
        member.setPassword("4444");
        member.setName("user01");
        memberRepository.save(member);
    }

    //@Test
    void testSelect1() {
        Integer member_id = 8;
        Optional<Member> result = memberRepository.findById(member_id);

        System.out.println("=========================");
        if(result.isPresent()) {
            Member member = result.get();
            System.out.println(member);
        } else {
            System.out.println("해당 회원을 찾을 수 없습니다.");
        }
    }

    //@Test
    void testSelect2() {
        Integer member_id = 5;
        memberRepository.findById(member_id).ifPresentOrElse(
                member -> System.out.println(member),
                () -> System.out.println("해당 회원을 찾을 수 없습니다.")
        );
    }

    //@Test
    void testSelect3() {
        Integer member_id = 3;
        try {
            Member member = memberRepository.findById(member_id)
                    .orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다."));
            System.out.println(member);
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}