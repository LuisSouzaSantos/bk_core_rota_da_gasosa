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
import br.com.fesa.rotadagasosa.service.AdministratorService;
import br.com.fesa.rotadagasosa.service.CustomerService;
import br.com.fesa.rotadagasosa.service.GasStationService;
import br.com.fesa.rotadagasosa.service.LoginService;
import br.com.fesa.rotadagasosa.service.TokenService;
import br.com.fesa.rotadagasosa.service.validator.LoginValidator;
import br.com.fesa.rotadagasosa.utils.Utils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private GasStationService gasStationService;
	
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
	
	@Override
	public Login getByUsername(String username) {
		if(Utils.isCPF(username)) { return customerService.getCredentialsByCPF(username);}
		
		if(Utils.isCNPJ(username)) { return gasStationService.getCredentialsByCNPJ(username); }
		
		if(Utils.isEmail(username)) { return administratorService.getCredentialsByEmail(username); }
		
		return null;
	}

}