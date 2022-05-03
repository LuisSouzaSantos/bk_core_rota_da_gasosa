package br.com.fesa.rotadagasosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.message.AuthenticationMessage;
import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.service.AuthService;
import br.com.fesa.rotadagasosa.service.TokenService;
import br.com.fesa.rotadagasosa.service.validator.LoginValidator;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@Override
	public Login authentication(Login login) throws LoginException {
		loginValidator.validateFields(login);
		
		if(login == null) { throw new LoginException(AuthenticationMessage.LOGIN_NOT_FOUND, HttpStatus.UNAUTHORIZED); }
		
		UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(credentials);
		
		String token = tokenService.generateToken(authentication);
		
		login.setToken(token);
		
		return login;
	}
	
}