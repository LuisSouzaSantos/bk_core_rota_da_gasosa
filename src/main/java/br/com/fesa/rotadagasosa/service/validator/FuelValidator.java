package br.com.fesa.rotadagasosa.service.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.FuelException;
import br.com.fesa.rotadagasosa.message.FuelMesage;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

@Service
public class FuelValidator {

	@Autowired
	private Validator validator;
	
	public void validateForm(BaseAdministratorItemForm availableTimeForm) throws FuelException {
		if(availableTimeForm == null) { throw new FuelException(FuelMesage.ERROR_FORM_NULL); }
		
		if(availableTimeForm.getName() == null || availableTimeForm.getName().isEmpty()) { throw new FuelException(FuelMesage.ERROR_FORM_NAME); }
	}
	
	public void validateFuelFields(Fuel fuel) throws FuelException {
		Set<ConstraintViolation<Fuel>> violations = validator.validate(fuel);

		if(violations.isEmpty() == false) { throw new FuelException(FuelMesage.ERROR_FIELDS); }
	}
	
}