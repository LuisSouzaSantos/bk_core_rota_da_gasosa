package br.com.fesa.rotadagasosa.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
	public String generateToken(Authentication authentication);
	
	public boolean isTokenValid(String token);
	
	public String getUsername(String token);
}