package br.com.fesa.rotadagasosa.service;

import java.util.List;

import br.com.fesa.rotadagasosa.exception.FuelException;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

public interface FuelService {

	public Fuel save(BaseAdministratorItemForm form) throws FuelException;
	
	public Fuel edit(Fuel fuel) throws FuelException;
	
	public void delete(Long id) throws FuelException;
	
	public List<Fuel> getAll();
	
}
