package com.example.birthStar.controller;

import com.example.birthStar.entity.StarEntity;
import com.example.birthStar.repository.StarRepository;
import com.example.birthStar.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class StarController {

    private final StarService starService;

    // 홈 페이지
    @GetMapping("/")
    public String root() {
        return "starResult";
    }

    // 별자리 조회
    @GetMapping("/star")
    public String getStar(@RequestParam("month") String month, Model model) {
        StarEntity star = starService.getStarByMonth(month);
        model.addAttribute("star", star);
        return "starResult";  // 별자리 결과 페이지로 이동
    }
}
