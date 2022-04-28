package br.com.fesa.rotadagasosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.repository.CustomerRepository;
import br.com.fesa.rotadagasosa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Login getCredentialsByCPF(String cpf) {
		return customerRepository.findCustomerCredentials(cpf);
	}

}
