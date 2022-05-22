package br.com.fesa.rotadagasosa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.AvailableTimeException;
import br.com.fesa.rotadagasosa.message.AvailableTimeMessage;
import br.com.fesa.rotadagasosa.model.AvailableTime;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.AvailableTimeRepository;
import br.com.fesa.rotadagasosa.service.AvailableTimeService;
import br.com.fesa.rotadagasosa.service.validator.AvailableTimeValidator;

@Service
public class AvailableTimeServiceImpl implements AvailableTimeService {

	@Autowired
	private AvailableTimeRepository availableTimeRepository;
	
	@Autowired
	private AvailableTimeValidator availableTimeValidator;
	
	
	@Override
	public AvailableTime save(BaseAdministratorItemForm form) throws AvailableTimeException {
		availableTimeValidator.validateForm(form);
		
		AvailableTime retrievedAvailableTimeByName = getByName(form.getName());
		
		if(retrievedAvailableTimeByName != null) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_DUPLICATE); }
		
		AvailableTime availableTime = new AvailableTime();
		availableTime.setName(form.getName());
		availableTime.setVisible(form.isVisible());
		
		return availableTimeRepository.save(availableTime);
	}

	@Override
	public AvailableTime edit(AvailableTime availableTime) throws AvailableTimeException {
		availableTimeValidator.validateAvailableTimeFields(availableTime);
		
		if(availableTime.getId() == null) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_ID_NULL); }
		
		AvailableTime retrievedAvailableTimeById = getById(availableTime.getId());
		
		if(retrievedAvailableTimeById == null) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_NULL); }
		
		AvailableTime retrievedAvailableTimeByName = getByName(availableTime.getName());
		
		if((retrievedAvailableTimeByName != null) && !availableTime.getId().equals(retrievedAvailableTimeByName.getId())) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_DUPLICATE); }
		
		retrievedAvailableTimeById.setName(availableTime.getName());
		retrievedAvailableTimeById.setVisible(availableTime.getVisible());
		
		return availableTimeRepository.save(retrievedAvailableTimeById);
	}

	@Override
	public void delete(Long id) throws AvailableTimeException {
		if(id == null) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_ID_NULL);  }
		
		availableTimeRepository.deleteById(id);
	}

	@Override
	public List<AvailableTime> getAll() {
		return availableTimeRepository.findAll();
	}
	
	private AvailableTime getByName(String name) {
		return availableTimeRepository.findByName(name);
	}
	
	private AvailableTime getById(Long id) {
		Optional<AvailableTime> availableTime = availableTimeRepository.findById(id);
		
		if(availableTime.isPresent() == false) { return null; }
		
		return availableTime.get();
	}

}
