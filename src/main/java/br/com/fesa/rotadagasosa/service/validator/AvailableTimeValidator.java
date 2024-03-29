package br.com.fesa.rotadagasosa.service.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.AvailableTimeException;
import br.com.fesa.rotadagasosa.message.AvailableTimeMessage;
import br.com.fesa.rotadagasosa.model.AvailableTime;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

@Service
public class AvailableTimeValidator {
	
	@Autowired
	private Validator validator;

	public void validateForm(BaseAdministratorItemForm availableTimeForm) throws AvailableTimeException {
		if(availableTimeForm == null) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_FORM_NULL); }
		
		if(availableTimeForm.getName() == null || availableTimeForm.getName().isEmpty()) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_FORM_NAME); }
	}
	
	public void validateAvailableTimeFields(AvailableTime availableTime) throws AvailableTimeException {
		Set<ConstraintViolation<AvailableTime>> violations = validator.validate(availableTime);

		if(violations.isEmpty() == false) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_FIELDS); }
	}
	
}
