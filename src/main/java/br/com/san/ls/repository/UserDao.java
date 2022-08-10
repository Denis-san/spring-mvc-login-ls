package br.com.san.ls.repository;

import br.com.san.ls.entity.User;

public interface UserDao {

	void saveNewUser(User user);
	
	boolean usernameAlreadyExists(String loginName);
	
}
