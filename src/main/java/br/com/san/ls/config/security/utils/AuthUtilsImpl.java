package br.com.san.ls.config.security.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthUtilsImpl implements AuthUtils {

	@Override
	public boolean userIsAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth == null || AnonymousAuthenticationToken.class.isAssignableFrom(auth.getClass())) {
			return false;
		}

		return auth.isAuthenticated();
	}

}
