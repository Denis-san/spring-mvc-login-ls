package br.com.san.ls.service;

import br.com.san.ls.entity.dto.UserDTO;
import br.com.san.ls.service.exception.UserAlreadyExistsException;

public interface UserService {

	void saveNewUser(UserDTO userDTO) throws UserAlreadyExistsException;
	
	boolean loginNameAlreadyExists(String loginName);
}
