package com.example.demo2.controller;

import com.example.demo2.entity.Member;
import com.example.demo2.repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/registForm")
    public String registForm(Model model){
        model.addAttribute("member", new Member());
        return "membersForm";
    }

    @PostMapping("/regist")
    public String regist(@Valid @ModelAttribute("member") Member member, BindingResult result){

        if(result.hasErrors()){
            return "membersForm";
        }
        memberRepository.save(member);
        return "redirect:member/list";
    }

}
