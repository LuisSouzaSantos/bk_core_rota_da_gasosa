package br.com.fesa.rotadagasosa.service.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.message.AuthenticationMessage;
import br.com.fesa.rotadagasosa.model.Login;

@Service
public class LoginValidator {

	@Autowired
	private Validator validator;
	
	public void validateFields(Login login) throws LoginException {
		Set<ConstraintViolation<Login>> violations = validator.validate(login);

		if(violations.isEmpty() == false) { throw new LoginException(AuthenticationMessage.ERROR_CREDENTIALS_FIELDS, HttpStatus.UNAUTHORIZED); }
	}
	
}
