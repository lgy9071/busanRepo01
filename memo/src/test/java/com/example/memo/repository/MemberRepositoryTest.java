package com.example.memo.repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.memo.entity.Member;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testDelete() {
    	Integer member_id = 2;
    	
    	memberRepository.deleteById(member_id);
    }
    
    //@Transactional
    //@Test
    public void testUpdate() {
    	/*
    	Member member = Member.builder()
    			.member_id(1)
    			.username("user1")
    			.password("4444")
    			.build();
    	*/
    	Member member = memberRepository.findById(1).orElseThrow();
    	member.setPassword("4444");
    	member.setName("user01");
    	memberRepository.save(member);
    	}
    
    
    //@Test
    void testSelect3() {
    	Integer member_id = 3;
    	try {
    		Member member = memberRepository.findById(member_id)
    				.orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다."));
    		System.out.println(member);
    	}catch(NoSuchElementException e) {
    		System.out.println(e.getMessage());
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
    void testSelect1() {
    	Integer member_id = 8;
    	
    	Optional<Member> result = memberRepository.findById(member_id);
    	
    	System.out.println("=========================");
    	if(result.isPresent()) {
    		Member member = result.get();
    		System.out.println(member);
    	}else {
    		System.out.println("해당 회원을 찾을 수 없습니다.");
    	}
    }
    
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
}