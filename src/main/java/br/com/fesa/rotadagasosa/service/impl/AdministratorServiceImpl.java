package br.com.fesa.rotadagasosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.repository.AdministratorRepository;
import br.com.fesa.rotadagasosa.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;
	
	@Override
	public Login getCredentialsByEmail(String email) {
		return administratorRepository.findAdministratorCredentials(email);
	}

}
