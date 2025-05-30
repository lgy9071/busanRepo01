package com.example.theater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.theater.dao.IPerformanceDao;
import com.example.theater.dao.IReserveDao;
import com.example.theater.dto.performanceDto;
import com.example.theater.dto.reserveDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class reserveController {

	@Autowired
	private IReserveDao reserveDao;

	@Autowired
	private IPerformanceDao performanceDao; // 공연 목록 DAO

	// 예매 폼 페이지
	@GetMapping("/reserveForm")
	public String showReserveForm(@RequestParam("pid") int pid, Model model) {
		// 해당 공연 정보를 가져옵니다.
		performanceDto performance = performanceDao.getPerformanceById(pid);
		List<performanceDto> performanceList = performanceDao.getList(); // 공연 목록

		model.addAttribute("performance", performance); // 선택한 공연
		model.addAttribute("performanceList", performanceList); // 모든 공연 목록
		return "reserveForm"; // reserveForm.jsp로 리턴
	}

	// 예매 추가
	@PostMapping("/insertReserve")
	public String insertReserve(@RequestParam("pid") int pid, HttpSession session,
			RedirectAttributes redirectAttributes) {
		String mid = (String) session.getAttribute("loginId");

		if (mid == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/login";
		}
		// 공연 정보 조회
	    performanceDto performance = performanceDao.getPerformanceById(pid);
	    if (performance == null) {
	        redirectAttributes.addFlashAttribute("msg", "공연 정보를 찾을 수 없습니다.");
	        return "redirect:/performanceList";
	    }
	    // 예매 DTO 생성
		reserveDto dto = new reserveDto();
		dto.setPid(pid);
		dto.setMid(mid);
		dto.setShowTitle(performance.getTitle());
		
		reserveDao.insertReserve(dto);
		//System.out.println("예매 데이터 삽입됨: " + dto);

		return "redirect:/reserveList"; // 예매 목록 페이지로 이동
	}

	// 예매 목록 페이지
	@GetMapping("/reserveList")
	public String reserveList(Model model) {
		//System.out.println("=== /reserveList 컨트롤러 진입 ===");
	    List<reserveDto> reserves = reserveDao.getReserveListAll();

	    if (reserves == null || reserves.isEmpty()) {
	        System.out.println("예매 목록이 없습니다.");
	    } else {
	        for (reserveDto r : reserves) {
	            //System.out.println("예매 데이터: " + r.getRid() + ", " + r.getShowTitle());
	        }
	    }

	    model.addAttribute("reserveList", reserves);
	    return "reserveList"; // reserveList.jsp
	}
}
