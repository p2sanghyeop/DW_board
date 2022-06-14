package com.dw.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String callLoginpage() {
		return "login";
	}
	
	@GetMapping("/join")
	public String callJoinPage() {
		return "join";
	}
	
	@GetMapping("/logout")
	public String callLogiout(HttpSession httpsession) {
		//새션 삭제
		httpsession.removeAttribute("studentsId");
		httpsession.removeAttribute("studentsPassword");
		return "login";
	}
}
