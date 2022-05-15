package br.com.san.ls.config.security.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import br.com.san.ls.config.security.authentication.service.LoginAttemptService;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private LoginAttemptService loginAttemptService;

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		String header = request.getHeader("X-Forwarded-For");

		if (header == null) {
			loginAttemptService.loginSuccess(request.getRemoteAddr());
		} else {
			loginAttemptService.loginSuccess(header.split(",")[0]);
		}
	}

}
