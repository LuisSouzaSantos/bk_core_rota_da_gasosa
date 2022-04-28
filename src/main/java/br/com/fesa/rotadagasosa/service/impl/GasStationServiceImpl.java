package br.com.fesa.rotadagasosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.repository.GasStationRepository;
import br.com.fesa.rotadagasosa.service.GasStationService;

@Service
public class GasStationServiceImpl implements GasStationService {

	@Autowired
	private GasStationRepository gasStationRepository;
	
	@Override
	public Login getCredentialsByCNPJ(String cnpj) {
		return gasStationRepository.findGasStationCredentials(cnpj);
	}

}
