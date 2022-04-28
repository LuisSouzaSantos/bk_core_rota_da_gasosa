package br.com.fesa.rotadagasosa.service;

import br.com.fesa.rotadagasosa.model.Login;

public interface AdministratorService {

	public Login getCredentialsByEmail(String email);
	
}
