package br.com.fesa.rotadagasosa.exception;

public class ServiceException extends AppException {

	private static final long serialVersionUID = 1L;
	
	public ServiceException(String exceptionMessage) {
		super(exceptionMessage);
	}

}