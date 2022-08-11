package br.com.san.ls.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.san.ls.config.security.utils.AuthUtils;
import br.com.san.ls.entity.dto.UserDTO;
import br.com.san.ls.entity.dto.UserLoginDTO;
import br.com.san.ls.service.UserService;
import br.com.san.ls.service.exception.UserAlreadyExistsException;

@RequestMapping("/register")
@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthUtils authUtils;

	@GetMapping("/new")
	public ModelAndView showRegisterForm() {
		ModelAndView mv = new ModelAndView("user-register");

		if (authUtils.userIsAuthenticated()) {
			mv.setViewName("redirect:/user/home");
		} else {
			mv.addObject("user", new UserDTO());
		}

		return mv;
	}

	@PostMapping("/processRegister")
	public ModelAndView processRegister(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bdResult,
			HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttribute) {
		ModelAndView mv = new ModelAndView("user-register");

		if (bdResult.hasErrors() == false) {
			UserLoginDTO userLoginDTO = userDTO.getUserLoginDTO();
			try {
				userService.saveNewUser(userDTO);
				authAutoLogin(request, userLoginDTO.getLoginName(), userLoginDTO.getPassword());
				mv.setViewName("redirect:/user/home");
			} catch (ServletException e) {
				redirectAttribute.addFlashAttribute("registerAutoLoginFail",
						"Não foi possível realizar o login. Tente novamente");
				mv.setViewName("redirect:/login");
			} catch (UserAlreadyExistsException e) {
				mv.addObject("errorloginNameAlreadyExist", e.getMessage());
			}
		} else {
			for (FieldError error : bdResult.getFieldErrors()) {
				if (error.getDefaultMessage().contains("senhas")) {
					mv.addObject("passwordVerifyError", error.getDefaultMessage());
				}
			}
			mv.addObject("user", userDTO);
		}

		return mv;
	}

	private void authAutoLogin(HttpServletRequest request, String username, String password) throws ServletException {
		request.login(username, password);
	}

}
