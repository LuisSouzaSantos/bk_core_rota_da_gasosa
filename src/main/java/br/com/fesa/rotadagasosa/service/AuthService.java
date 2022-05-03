package br.com.fesa.rotadagasosa.service;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.model.Login;

public interface AuthService {

	public Login authentication(Login login) throws LoginException;
	
}
