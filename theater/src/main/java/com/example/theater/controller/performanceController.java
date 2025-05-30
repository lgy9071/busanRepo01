package com.example.theater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.theater.dao.IPerformanceDao;
import com.example.theater.dao.IReviewDao;
import com.example.theater.dto.performanceDto;
import com.example.theater.dto.reviewDto;

@Controller
public class performanceController {

	@Autowired
	private IPerformanceDao dao;
	@Autowired
	private IReviewDao reviewDao;
	
	@GetMapping("/performanceForm")
	public String showForm() {
		return "performanceForm";
	}
	
	@PostMapping("/performanceForm")
	public String submitForm(performanceDto dto) {
		dao.insertPerformance(dto);
		return "redirect:/performanceList";
	}
	
	@GetMapping("/performanceList")
	public String perlist(Model model) {
		model.addAttribute("list", dao.getList());
		return "performanceList";
	}

	@GetMapping("/performanceDetail")
	public String perdetail(@RequestParam("pid") int pid, Model model) {
		performanceDto performance = dao.getPerformanceById(pid);

		List<reviewDto> reviews = reviewDao.getReviewsByPerformance(pid);
		
		model.addAttribute("performance", performance);
		model.addAttribute("reviewList", reviews);
		
		return "performanceDetail";
	}

	@PostMapping("/addPerformance")
	public String add(performanceDto dto) {
	    dao.insertPerformance(dto);
	    return "redirect:/performanceList";
	}

}
