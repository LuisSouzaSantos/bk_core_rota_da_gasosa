package br.com.fesa.rotadagasosa.service;

import java.util.List;

import br.com.fesa.rotadagasosa.exception.ServiceException;
import br.com.fesa.rotadagasosa.model.Service;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

public interface ServiceService {
	
	public Service save(BaseAdministratorItemForm form) throws ServiceException;
	
	public Service edit(Service service) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public List<Service> getAll();

}
