package br.com.fesa.rotadagasosa.exception;

import org.springframework.http.HttpStatus;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;
	private HttpStatus code;
	
	public AppException(String exceptionMessage) {
		super(exceptionMessage);
		this.exceptionMessage = exceptionMessage;
	}

	public AppException(String exceptionMessage, HttpStatus code) {
		super(exceptionMessage);
		this.exceptionMessage = exceptionMessage;
		this.code = code;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

}