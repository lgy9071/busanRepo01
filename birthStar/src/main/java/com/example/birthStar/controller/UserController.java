package com.example.birthStar.controller;

import com.example.birthStar.entity.UserEntity;
import com.example.birthStar.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }

    @GetMapping("/starResult")
    public String index(){
        return "/starResult";
    }

    @GetMapping("/signup")
    public String signupProc(){
        return "/signup";
    }

    @PostMapping("/signup")
    public String signupForm(UserEntity user){
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/loginForm?joined=true";
    }

    @GetMapping("/login")
    public String loginForm(){

        return "/loginForm";
    }

    @PostMapping("/login")
    public String loginProc(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){

        UserEntity user = userRepository.findByUsername(username);

        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("user", user);
        }

        if("ROLE_ADMIN".equals(user.getRole())){
            return "redirect:/admin";
        } else if("ROLE_USER".equals(user.getRole())){
            return "redirect:/starResult";
        } else {
            return "redirect:/loginForm?error=true";
        }

    }

}
