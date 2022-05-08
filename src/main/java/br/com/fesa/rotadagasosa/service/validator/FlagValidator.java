package br.com.fesa.rotadagasosa.service.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.FlagException;
import br.com.fesa.rotadagasosa.message.FlagMessage;
import br.com.fesa.rotadagasosa.model.Flag;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

@Service
public class FlagValidator {

	@Autowired
	private Validator validator;
	
	public void validateForm(BaseAdministratorItemForm form) throws FlagException {
		if(form == null) { throw new FlagException(FlagMessage.ERROR_FORM_NULL); }
		
		if(form.getName() == null || form.getName().isEmpty()) { throw new FlagException(FlagMessage.ERROR_FORM_NAME); }
	}
	
	public void validateFlagFields(Flag flag) throws FlagException {
		Set<ConstraintViolation<Flag>> violations = validator.validate(flag);

		if(violations.isEmpty() == false) { throw new FlagException(FlagMessage.ERROR_FIELDS); }
	}
	
}
