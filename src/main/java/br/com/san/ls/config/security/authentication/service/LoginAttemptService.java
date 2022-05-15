package br.com.san.ls.config.security.authentication.service;

public interface LoginAttemptService {
	
	public void loginSuccess(String key);
	
	public void loginFail(String key);
	
	public boolean isBlocked(String key);
	
}
