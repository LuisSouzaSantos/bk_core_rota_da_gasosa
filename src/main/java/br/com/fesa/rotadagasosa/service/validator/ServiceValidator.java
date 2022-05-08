package br.com.fesa.rotadagasosa.service.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.ServiceException;
import br.com.fesa.rotadagasosa.message.ServiceMessage;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

@Service
public class ServiceValidator {

	@Autowired
	private Validator validator;
	
	public void validateForm(BaseAdministratorItemForm form) throws ServiceException {
		if(form == null) { throw new ServiceException(ServiceMessage.ERROR_FORM_NULL); }
		
		if(form.getName() == null || form.getName().isEmpty()) { throw new ServiceException(ServiceMessage.ERROR_FORM_NAME); }
	}
	
	public void validateServiceFields(Service service) throws ServiceException {
		Set<ConstraintViolation<Service>> violations = validator.validate(service);

		if(violations.isEmpty() == false) { throw new ServiceException(ServiceMessage.ERROR_FIELDS); }
	}
	
}
