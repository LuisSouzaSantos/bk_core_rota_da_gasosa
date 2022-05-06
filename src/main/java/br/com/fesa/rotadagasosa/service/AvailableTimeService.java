package br.com.fesa.rotadagasosa.service;

import java.util.List;

import br.com.fesa.rotadagasosa.exception.AvailableTimeException;
import br.com.fesa.rotadagasosa.model.AvailableTime;
import br.com.fesa.rotadagasosa.model.form.dto.AvailableTimeForm;

public interface AvailableTimeService {

	public AvailableTime save(AvailableTimeForm form) throws AvailableTimeException;
	
	public AvailableTime edit(AvailableTime availableTime);
	
	public void delete(Long id) throws AvailableTimeException;
	
	public List<AvailableTime> getAll();
	
}
