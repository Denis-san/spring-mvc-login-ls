package br.com.san.ls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.san.ls.entity.UserLogin;
import br.com.san.ls.repository.UserLoginDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserLoginDAO userLoginDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserLogin userLogin = userLoginDao.findByEmail(username);
		
		if(userLogin == null) {
			throw new UsernameNotFoundException("Usuario não existe");
		}
		
		return userLogin;
	}

}
