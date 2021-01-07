package online_bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import online_bookstore.Service.BookInfoService;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	@Autowired
    BookInfoService bookInfoService;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("newbooks", bookInfoService.newbooklist());
		model.addAttribute("bestbooks", bookInfoService.bestbooklist());
		model.addAttribute("choicebooks", bookInfoService.choicebooklist());
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail() {
		return "detail";
	}
}
