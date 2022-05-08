package br.com.fesa.rotadagasosa.service;

import java.util.List;

import br.com.fesa.rotadagasosa.exception.AvailableTimeException;
import br.com.fesa.rotadagasosa.model.AvailableTime;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

public interface AvailableTimeService {

	public AvailableTime save(BaseAdministratorItemForm form) throws AvailableTimeException;
	
	public AvailableTime edit(AvailableTime availableTime) throws AvailableTimeException;
	
	public void delete(Long id) throws AvailableTimeException;
	
	public List<AvailableTime> getAll();
	
}
