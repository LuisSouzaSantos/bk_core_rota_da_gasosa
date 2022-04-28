package br.com.fesa.rotadagasosa.service;

import br.com.fesa.rotadagasosa.model.Login;

public interface CustomerService {

	public Login getCredentialsByCPF(String cpf);
	
}