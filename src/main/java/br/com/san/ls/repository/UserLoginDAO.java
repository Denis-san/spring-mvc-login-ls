package br.com.san.ls.repository;

import br.com.san.ls.entity.UserLogin;

public interface UserLoginDAO {
	
	public UserLogin findByEmail(String email);
	
}
