package br.com.fesa.rotadagasosa.service.impl;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public String generateToken(Authentication authentication) {
		Login login = (Login) authentication.getPrincipal();
		Date today = new Date();
		Date expirationDate = new Date(today.getTime() + 1000000L);
		
		return Jwts.builder()
				.setIssuer(login.getCredentialsType().toString())
				.setSubject(login.getUsername())
				.setIssuedAt(today)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, "JSDHJAHDJHADJJASHDJHAJSHDJH")
				.compact();
	}

	@Override
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser()
				.setSigningKey("JSDHJAHDJHADJJASHDJHAJSHDJH")
				.parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public String getUsername(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey("JSDHJAHDJHADJJASHDJHAJSHDJH")
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}

}