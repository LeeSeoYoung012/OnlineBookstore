package online_bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {	
	@RequestMapping("/Join")
	public String Join() {
		return "Member/Join";
	}
	
	@RequestMapping("/Login")
	public String Longin() {
		return "Member/Login";
	}

	@RequestMapping("/cart")
	public String Cart() {return "Member/Cart";}

}
