package br.com.san.ls.config.security.authentication.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import br.com.san.ls.config.security.authentication.constant.FilePathConstant;

@Service
public class LoginAttemptServiceImpl implements LoginAttemptService {

	@Autowired
	private IpAddressUtils ipAddressUtils;
	private static final int MAX_ATTEMPTS = 5;
	private LoadingCache<String, Integer> attemptsCache;

	public LoginAttemptServiceImpl() {
		super();
		attemptsCache = CacheBuilder.newBuilder().expireAfterAccess(8, TimeUnit.HOURS)
				.build(new CacheLoader<String, Integer>() {
					@Override
					public Integer load(String key) throws Exception {
						return 0;
					}
				});
	}

	@Override
	public void loginSuccess(String key) {
		attemptsCache.invalidate(key);
	}

	@Override
	public void loginFail(String key) {
		int attempts = 0;

		try {
			attempts = attemptsCache.get(key);
		} catch (ExecutionException e) {
			attempts = 0;
		}

		attempts++;
		attemptsCache.put(key, attempts);
	}

	@Override
	public boolean isBlocked(String key) {
		try {

			if (ipAddressUtils.existIp(key, FilePathConstant.PATH_FILE_ID_BLOCK)) {
				return true;
			}

			if (attemptsCache.get(key) >= MAX_ATTEMPTS) {
				ipAddressUtils.registerIdBlock(key, FilePathConstant.PATH_FILE_ID_BLOCK);
				return true;
			}
		} catch (ExecutionException e) {
			return false;
		}

		return false;
	}

	
}
