package br.com.fesa.rotadagasosa.service;

import br.com.fesa.rotadagasosa.model.Login;

public interface GasStationService {

	public Login getCredentialsByCNPJ(String cnpj);
	
}
