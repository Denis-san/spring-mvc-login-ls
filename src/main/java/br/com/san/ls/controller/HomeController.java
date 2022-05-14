package br.com.san.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome() {
		return "home.html";
	}
	
	
	@RequestMapping("/user/home")
	public String showUserHome() {
		return "user-home.html";
	}
	
	
}
