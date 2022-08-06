package br.com.san.ls.service;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.san.ls.config.security.authentication.service.LoginAttemptService;
import br.com.san.ls.entity.UserLogin;
import br.com.san.ls.repository.UserLoginDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserLoginDAO userLoginDao;

	@Autowired
	private LoginAttemptService loginAttemptService;

	@Autowired
	private HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, NoResultException {

		String ip = getClientIp();
		UserLogin userLogin;

		if (loginAttemptService.isBlocked(ip)) {
			userLogin = null;
		} else {
			userLogin = userLoginDao.findByEmail(username);
		}
		
		
		if (userLogin == null) {
			throw new UsernameNotFoundException("Usuario não existe");
		}

		return userLogin;
	}

	private String getClientIp() {
		String xfHeader = request.getHeader("X-Forwarded-For");

		if (xfHeader == null) {
			return request.getRemoteAddr();
		} else {
			return xfHeader.split(",")[0];
		}
	}

}
