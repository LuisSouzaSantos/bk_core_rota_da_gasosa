package br.com.fesa.rotadagasosa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fesa.rotadagasosa.exception.ServiceException;
import br.com.fesa.rotadagasosa.message.ServiceMessage;
import br.com.fesa.rotadagasosa.model.Service;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.ServiceRepository;
import br.com.fesa.rotadagasosa.service.ServiceService;
import br.com.fesa.rotadagasosa.service.validator.ServiceValidator;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ServiceValidator serviceValidator;

	@Override
	public Service save(BaseAdministratorItemForm form) throws ServiceException {
		//serviceValidator.validateForm(form);
		
		Service retrivedServiceByName = getByName(form.getName());
		
		if(retrivedServiceByName != null) { throw new ServiceException(ServiceMessage.ERROR_DUPLICATE); }
		
		Service service = new Service();
		service.setName(form.getName());
		service.setVisible(form.isVisible());
		
		return serviceRepository.save(service);
	}

	@Override
	public Service edit(Service service) throws ServiceException {
		//serviceValidator.validateServiceFields(service);
		
		if(service.getId() == null) { throw new ServiceException(ServiceMessage.ERROR_ID_NULL); }
		
		Service serviceById = getById(service.getId());
		
		if(serviceById == null) { throw new ServiceException(ServiceMessage.ERROR_NULL); }
		
		Service serviceByName = getByName(service.getName());
		
		if((serviceByName != null) && (!serviceByName.getId().equals(serviceById.getId()))) { throw new ServiceException(ServiceMessage.ERROR_DUPLICATE); }
		
		serviceById.setName(service.getName());
		serviceById.setVisible(service.getVisible());
		
		return serviceRepository.save(serviceById);
	}

	@Override
	public void delete(Long id) throws ServiceException {
		if(id == null) { throw new ServiceException(ServiceMessage.ERROR_ID_NULL); }
		
		serviceRepository.deleteById(id);
	}

	@Override
	public List<Service> getAll() {
		return serviceRepository.findAll();
	}
	
	private Service getByName(String name) {
		return serviceRepository.findByName(name);
	}
	
	private Service getById(Long id) {
		Optional<Service> service = serviceRepository.findById(id);
		
		if(service.isPresent() == false) { return null; }
		
		return service.get();
	}
	
}