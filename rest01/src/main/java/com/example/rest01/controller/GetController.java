package com.example.rest01.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest01.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

	List<MemberDto> list = new ArrayList<>();
	
	//http://localhost:8090/api/v1/get-api/hello
	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello...");
		return "Hello World";
	}
	
	//http://localhost:8090/api/v1/get-api/variable1/{variable}
	@GetMapping("/variable1/{variable}")
	public String getVariable(@PathVariable("variable") String variable) {
	    System.out.println("Received variable: " + variable);
	    return "Received: " + variable;
	}
	
	// http://localhost:8090/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping("/request1")
	public String getRequest1(@RequestParam("name") String name, 
								@RequestParam("email") String email, 
								@RequestParam("organization") String organization) {
	    System.out.println(name + ", " + email + ", " + organization);
	    
	    return "name: " + name + ", email: " + email + ", organization: " + organization;
	}
	
	// http://localhost:8090/api/v1/get-api/request2?key1=value1&key2=value2
	@GetMapping("/request2")
	public String getRequest2(@RequestParam Map<String, String> param) {
	    StringBuilder sb = new StringBuilder();
	    param.entrySet().forEach(map -> {
	    	sb.append(map.getKey() + " : " + map.getValue() + "\n");
	    });
	    
//	    param.forEach((key, value) -> {
//	        //System.out.println(key + " = " + value);
//	        sb.append(key).append(" = ").append(value).append("\n");
//	    });

	    return sb.toString();
	}
	
	// http://localhost:8090/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping("/request3")
	public String getRequest3(MemberDto memberDto) {
		System.out.println("name : " + memberDto.getName());
		System.out.println("email : " + memberDto.getEmail());
		System.out.println("organization : " + memberDto.getOrganization());
		
		return "name : " + memberDto.getName() 
			+ "email : " + memberDto.getEmail() 
			+ "organization : " + memberDto.getOrganization();
	}
	
	@GetMapping("/request4/{name}")
	public ResponseEntity<Map<Integer, MemberDto>> getRequest4(@PathVariable("name") String name) {
	    Map<Integer, MemberDto> result = new HashMap<>();

	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i).getName().equalsIgnoreCase(name)) {
	            result.put(i, list.get(i));
	            return ResponseEntity.ok(result);
	        }
	    }

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	// http://localhost:8090/api/v1/get-api/request5/{name}
	@GetMapping("/request5/{name}")
	public int getRequest5(@PathVariable("name") String name) {

		MemberDto member1 = new MemberDto();
	    member1.setName("Ann");
	    member1.setEmail("Ann@green.com");
	    member1.setOrganization("GREEN");

	    MemberDto member2 = new MemberDto();
	    member2.setName("Bnn");
	    member2.setEmail("Bnn@green.com");
	    member2.setOrganization("GREEN");

	    MemberDto member3 = new MemberDto();
	    member3.setName("Cnn");
	    member3.setEmail("Cnn@green.com");
	    member3.setOrganization("GREEN");

	    list.add(member1);
	    list.add(member2);
	    list.add(member3);

	    for (MemberDto member : list) {
	        if (member.getName().equals(name)) {
	            return 200;
	        }
	    }

	    return 404;
	}
	
	@GetMapping("/request6/{name}")
	public Map<Integer, MemberDto> getRequest6(@PathVariable("name") String name) {

	    MemberDto member1 = new MemberDto();
	    member1.setName("Ann");
	    member1.setEmail("Ann@green.com");
	    member1.setOrganization("GREEN");

	    MemberDto member2 = new MemberDto();
	    member2.setName("Bnn");
	    member2.setEmail("Bnn@green.com");
	    member2.setOrganization("GREEN");

	    MemberDto member3 = new MemberDto();
	    member3.setName("Cnn");
	    member3.setEmail("Cnn@green.com");
	    member3.setOrganization("GREEN");

	    list.add(member1);
	    list.add(member2);
	    list.add(member3);

	    Map<Integer, MemberDto> result = new HashMap<>();
	    // 검색
	    boolean flag = false;
	    for (MemberDto m : list) {
	        if (m.getName().equals(name)) {
	            result.put(200, m);
	            flag = true;
	            break;
	        }
	    }
	    if(!flag) {
	    	result.put(404, null);
	    }
	    return result;
	}
	
	// http://localhost:8090/api/v1/get-api/request7/{name}
		@GetMapping("/request7/{name}")
		public ResponseEntity<MemberDto> getRequest7(@PathVariable("name") String name) {

		    MemberDto member1 = new MemberDto();
		    member1.setName("Ann");
		    member1.setEmail("Ann@green.com");
		    member1.setOrganization("GREEN");

		    MemberDto member2 = new MemberDto();
		    member2.setName("Bnn");
		    member2.setEmail("Bnn@green.com");
		    member2.setOrganization("GREEN");

		    MemberDto member3 = new MemberDto();
		    member3.setName("Cnn");
		    member3.setEmail("Cnn@green.com");
		    member3.setOrganization("GREEN");

		    list.add(member1);
		    list.add(member2);
		    list.add(member3);

		    // 검색
		    for (MemberDto m : list) {
		        if (m.getName().equals(name)) {
		            //return ResponseEntity.status(HttpStatus.OK).body(m);
		            //return ResponseEntity.status(200).body(m);
		            return ResponseEntity.ok(m); //제일 축약된 형식
		        }
		    }
		    return ResponseEntity.notFound().build();
		    //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	
}
