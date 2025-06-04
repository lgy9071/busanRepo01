package com.example.rest01.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest01.dto.MemberDto;
import com.example.rest01.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

	@Autowired
	MemberRepository memberRepository;
	
	//http://localhost:8090/api/v1/post-api/domain
	@PostMapping("/domain")
	public String postEx() {
		return "Hello Post API";
	}
	
	//http://localhost:8090/api/v1/post-api/member
	@PostMapping("/member")
	public String postMember(@RequestBody MemberDto member) {
		
		return "이름 : " + member.getName() +
				"이메일 : " + member.getEmail() + 
				"소속 : " + member.getOrganization();
	}
	
	//http://localhost:8090/api/v1/post-api/member2
	@PostMapping("/member2")
	public String postMember2(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
			
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + ":" + map.getValue() + "\n");
		});
			
		return sb.toString();
	}
	
	//http://localhost:8090/api/v1/post-api/member3
	@PostMapping("/member3")
	public ResponseEntity<MemberDto> postMember3(@RequestBody MemberDto member) {
	    // email이 null인 경우
	    if (member.getEmail() == null || member.getEmail().isEmpty()) {
	        return ResponseEntity.badRequest().build();
	    }

	    // email이 중복인 경우
	    if (member.getEmail().equals("ann@green.com")) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    }

	    // 정상 등록된 경우
	    if(memberRepository.addMember(member)) {
	    	return ResponseEntity.status(HttpStatus.CREATED).body(member);
	    }
	    
	    return ResponseEntity.unprocessableEntity().build();
	}

}
