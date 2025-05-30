package com.example.theater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.theater.dao.IPerformanceDao;
import com.example.theater.dao.IReviewDao;
import com.example.theater.dto.reviewDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class reviewController {

    @Autowired
    private IReviewDao reviewdao;

    @GetMapping("/reviewList")
    public String reviewList(@RequestParam int pid, Model model) {
        List<reviewDto> list = reviewdao.getReviewsByPerformance(pid);
        model.addAttribute("reviewList", list);
        return "reviewList";
    }

    // 공연 상세에서 바로 후기 작성
    @PostMapping("/review")
    public String insertReview(@RequestParam("pid") int pid,
                               @RequestParam("rating") int rating,
                               @RequestParam("rcomment") String rcomment,
                               HttpSession session, Model model) {
        String mid = (String) session.getAttribute("loginId");
        reviewDto dto = new reviewDto();
        dto.setPid(pid);
        dto.setRating(rating);
        dto.setRcomment(rcomment);
        dto.setMid(mid);
        reviewdao.insertReview(dto); //DAO 호출
        return "redirect:/performanceDetail?pid=" + pid;
    }
}