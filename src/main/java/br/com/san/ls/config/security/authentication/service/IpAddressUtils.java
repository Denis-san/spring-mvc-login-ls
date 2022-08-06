package br.com.san.ls.config.security.authentication.service;

public interface IpAddressUtils {
	public boolean existIp(String ip, String pathFile);
	public void registerIdBlock(String ip, String pathFile);
	
}
