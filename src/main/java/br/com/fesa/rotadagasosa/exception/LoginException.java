package br.com.fesa.rotadagasosa.exception;

import org.springframework.http.HttpStatus;

public class LoginException extends AppException {

	private static final long serialVersionUID = 1L;
	
	public LoginException(String exceptionMessage, HttpStatus code) {
		super(exceptionMessage, code);
	}
	
}