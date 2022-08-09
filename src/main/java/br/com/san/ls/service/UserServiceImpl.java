package br.com.san.ls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.san.ls.entity.User;
import br.com.san.ls.entity.dto.UserDTO;
import br.com.san.ls.repository.UserDao;
import br.com.san.ls.service.exception.UserAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveNewUser(UserDTO userDTO) throws UserAlreadyExistsException {

		if (emailAlreadyExists(userDTO.getUserLoginDTO().getVerifyEmail())) {
			throw new UserAlreadyExistsException("Já existe uma conta com este email!");
		} else {

			User user = userDTO.toUser();
			user.getUserLogin().setUserPassword(passwordEncoder.encode(userDTO.getUserLoginDTO().getVerifyPassword()));
			
			userDao.saveNewUser(user);
		}
	}

	@Override
	public boolean emailAlreadyExists(String email) {
		return userDao.emailAlreadyExists(email);
	}

}
