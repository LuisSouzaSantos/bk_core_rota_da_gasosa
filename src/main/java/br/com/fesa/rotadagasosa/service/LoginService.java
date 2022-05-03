package br.com.fesa.rotadagasosa.service;

import br.com.fesa.rotadagasosa.model.Login;

public interface LoginService {
	
	public Login getByUsername(String username);
	
}