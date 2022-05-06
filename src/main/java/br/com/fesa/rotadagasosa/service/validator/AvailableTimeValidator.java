package br.com.fesa.rotadagasosa.service.validator;

import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.AvailableTimeException;
import br.com.fesa.rotadagasosa.message.AvailableTimeMessage;
import br.com.fesa.rotadagasosa.model.form.dto.AvailableTimeForm;

@Service
public class AvailableTimeValidator {

	public void validateForm(AvailableTimeForm availableTimeForm) throws AvailableTimeException {
		if(availableTimeForm == null) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_FORM_NULL); }
		
		if(availableTimeForm.getName() == null || availableTimeForm.getName().isEmpty()) { throw new AvailableTimeException(AvailableTimeMessage.ERROR_FORM_NAME); }
	}
	
}
