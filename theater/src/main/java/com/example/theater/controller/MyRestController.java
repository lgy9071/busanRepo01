package com.example.theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.theater.dao.IMemberDao;
import com.example.theater.dto.memberDto;

	@RestController
	public class MyRestController {
		// IMemberDao를 주입받기 위해 @Autowired 사용
		@Autowired
		private IMemberDao dao;

		@PostMapping("/regist")
		public String regist(memberDto dto) {
			// 아이디 중복 확인
			int idCount = dao.selectid(dto.getId());

			if (idCount > 0) {
				return "이미 존재하는 아이디입니다";

			}
			// 회원 가입
			dao.insertMember(dto);
			return "회원가입 성공! " + "가입한 아이디 :" + dto.getId();
		}
	}

