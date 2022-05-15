package br.com.san.ls.config.security.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import br.com.san.ls.config.security.authentication.service.LoginAttemptService;

@Component
public class AuthenticationFailListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent>{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		String header = request.getHeader("X-Forwarded-For");
		
		if(header == null) {
			loginAttemptService.loginFail(request.getRemoteAddr());
		}else {
			loginAttemptService.loginFail(header.split(",")[0]);
		}
	}

}
