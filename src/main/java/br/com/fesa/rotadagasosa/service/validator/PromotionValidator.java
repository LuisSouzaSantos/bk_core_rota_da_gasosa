package br.com.fesa.rotadagasosa.service.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.PromotionException;
import br.com.fesa.rotadagasosa.message.PromotionsMessage;
import br.com.fesa.rotadagasosa.model.Promotion;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

@Service
public class PromotionValidator {

	@Autowired
	private Validator validator;
	
	public void validateForm(BaseAdministratorItemForm form) throws PromotionException {
		if(form == null) { throw new PromotionException(PromotionsMessage.ERROR_FORM_NULL); }
		
		if(form.getName() == null || form.getName().isEmpty()) { throw new PromotionException(PromotionsMessage.ERROR_FORM_NAME); }
	}
	
	public void validatePromotionFields(Promotion promotion) throws PromotionException {
		Set<ConstraintViolation<Promotion>> violations = validator.validate(promotion);

		if(violations.isEmpty() == false) { throw new PromotionException(PromotionsMessage.ERROR_FIELDS); }
	}
	
}