package com.example.theater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.theater.dao.IEventDao;
import com.example.theater.dto.entryDto;
import com.example.theater.dto.eventDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class eventController {

	@Autowired
	private IEventDao dao;
	
	@GetMapping("/eventList")
	public String list(Model model) {
		model.addAttribute("list", dao.getList());
		return "eventList";
	}
	
	@GetMapping("/eventDetail")
	public String detail(@RequestParam("eno") int eno, Model model) {
		eventDto event = dao.getEvent(eno);
		model.addAttribute("event", event);
		return "eventDetail";
	}

	@PostMapping("/eventEntry")
	public String eventEntry(@RequestParam("eno") int eno, HttpSession session, RedirectAttributes rttr) {
	    String user_id = (String) session.getAttribute("userId");
	    
	    if (user_id == null) {
	        rttr.addFlashAttribute("msg", "로그인이 필요합니다.");
	        return "redirect:/login";
	    }
	    
	    int count = dao.getEntryCount(eno, user_id);
	    if (count >= 3) {
	        rttr.addFlashAttribute("msg", "이벤트는 3번까지 응모할 수 있습니다.");
	    } else {
	        // DTO로 insert
	        entryDto entry = new entryDto();
	        entry.setEno(eno);
	        entry.setUser_id(user_id);
	        dao.insertEntry(entry);

	        rttr.addFlashAttribute("msg", "응모 완료!");
	    }

	    return "redirect:/eventDetail?eno=" + eno;
	    }
	
	@GetMapping("/myEntries")
	public String myEntries(HttpSession session, Model model) {
	    String user_id = (String) session.getAttribute("userId");
	    if (user_id == null) return "redirect:/login";

	    List<entryDto> entries = dao.getUserEntries(user_id);
	    model.addAttribute("entryList", entries);
	    return "myEntryList"; // myEntryList.jsp
	}
	
	@PostMapping("/insertEvent")
	public String insertEvent(eventDto dto, RedirectAttributes rttr) {
	    dao.insertEvent(dto);
	    rttr.addFlashAttribute("msg", "이벤트 등록 완료!");
	    return "redirect:/eventList";
	}

	@GetMapping("/eventForm")
	public String eventForm() {
	    return "eventForm"; // 위 JSP 파일
	}

	
	
	
	
	
	}