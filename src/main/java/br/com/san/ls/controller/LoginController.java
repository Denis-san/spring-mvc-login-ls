package br.com.san.ls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.san.ls.config.security.authentication.constant.FilePathConstant;
import br.com.san.ls.config.security.authentication.service.IpAddressUtils;

@Controller
public class LoginController {
	
	@Autowired
	private IpAddressUtils ipAddressUtils;

	@GetMapping("/login")
	public String showLoginForm(HttpServletRequest request) {
		
		String ip = getClientIp(request);
		
		if(ipAddressUtils.existIp(ip, FilePathConstant.PATH_FILE_ID_BLOCK)) {
			return "exceeded-login-attempts";
		}
		
		return "login";
	}

	private String getClientIp(HttpServletRequest request) {
		String xfHeader = request.getHeader("X-Forwarded-For");

		if (xfHeader == null) {
			return request.getRemoteAddr();
		} else {
			return xfHeader.split(",")[0];
		}
	}

}