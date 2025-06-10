package com.example.memo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.memo.entity.Test1;

@SpringBootTest
class TestRepositoryTest {

	@Autowired
	TestRepository testRepository;
	
	@Test
	void insertTest() {

		Test1 test = new Test1();
		test.setTxt("test2.....");
		
		//Test1 result = testRepository.save(test);
		
		Test1 result = null;
		
		assertNotNull(result, "null이 아니어야 하는데..."); //assert 단정짓다
		
	}

}
