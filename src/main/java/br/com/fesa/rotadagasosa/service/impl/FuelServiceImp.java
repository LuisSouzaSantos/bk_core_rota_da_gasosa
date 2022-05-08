package br.com.fesa.rotadagasosa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.FuelException;
import br.com.fesa.rotadagasosa.message.FuelMesage;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.FuelRepository;
import br.com.fesa.rotadagasosa.service.FuelService;
import br.com.fesa.rotadagasosa.service.validator.FuelValidator;

@Service
public class FuelServiceImp implements FuelService {

	@Autowired
	private FuelRepository fuelRepository;
	
	@Autowired
	private FuelValidator fuelValidator;

	@Override
	public Fuel save(BaseAdministratorItemForm form) throws FuelException {
		fuelValidator.validateForm(form);
		
		Fuel retrivedFuelByName = getByName(form.getName());
		
		if(retrivedFuelByName != null) { throw new FuelException(FuelMesage.ERROR_DUPLICATE); }
		
		Fuel fuel = new Fuel();
		fuel.setName(form.getName());
		fuel.setVisible(form.isVisible());
		
		return fuelRepository.save(fuel);
	}

	@Override
	public Fuel edit(Fuel fuel) throws FuelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws FuelException {
		if(id == null) { throw new FuelException(FuelMesage.ERROR_ID_NULL); }
		
		fuelRepository.deleteById(id);
	}

	@Override
	public List<Fuel> getAll() {
		return fuelRepository.findAll();
	}

	private Fuel getByName(String name) {
		return fuelRepository.findByName(name);
	}
		
}