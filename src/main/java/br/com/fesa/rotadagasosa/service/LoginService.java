package br.com.fesa.rotadagasosa.service;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.model.Login;

public interface LoginService {
	
	public Login authentication(Login login) throws LoginException;
	
	public Login getByUsername(String username);
	
}