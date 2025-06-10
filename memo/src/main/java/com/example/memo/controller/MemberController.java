package com.example.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.memo.entity.Member;
import com.example.memo.repository.MemberRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // 회원 등록 폼 이동
    @GetMapping("/registForm")
    public String registForm(Model model) {
        model.addAttribute("member", new Member());
        return "membersForm";  // templates/membersForm.html
    }

    // 회원 등록 처리
    @PostMapping("/regist")
    public String regist(@Valid @ModelAttribute("member") Member member, BindingResult result) {

        if (result.hasErrors()) {
            return "membersForm";  // 유효성 검증 실패 시 다시 폼 보여줌
        }

        memberRepository.save(member);  // DB 저장
        return "redirect:/member/list"; // 등록 후 목록 페이지로 이동 (경로는 적절히 조정)
    }
}