package br.com.san.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.san.ls.entity.dto.UserDTO;

@RequestMapping("/register")
@Controller
public class RegisterController {
	
	@GetMapping("/new")
	public ModelAndView showRegisterForm() {
		ModelAndView mv = new ModelAndView("user-register");
		
		mv.addObject("user", new UserDTO());
		
		return mv;
	}
	
	
	
}
