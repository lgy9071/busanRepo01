package com.example.cart_ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductPageController {

    @GetMapping("/")
    public String root(){
        System.out.println("root...");
        return "/product";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "/admin";
    }

}
