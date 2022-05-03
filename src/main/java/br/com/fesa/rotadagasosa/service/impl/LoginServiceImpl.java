package br.com.fesa.rotadagasosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.service.AdministratorService;
import br.com.fesa.rotadagasosa.service.CustomerService;
import br.com.fesa.rotadagasosa.service.GasStationService;
import br.com.fesa.rotadagasosa.service.LoginService;
import br.com.fesa.rotadagasosa.utils.Utils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private GasStationService gasStationService;
	
	@Override
	public Login getByUsername(String username) {
		if(Utils.isCPF(username)) { return customerService.getCredentialsByCPF(username);}
		
		if(Utils.isCNPJ(username)) { return gasStationService.getCredentialsByCNPJ(username); }
		
		if(Utils.isEmail(username)) { return administratorService.getCredentialsByEmail(username); }
		
		return null;
	}

}