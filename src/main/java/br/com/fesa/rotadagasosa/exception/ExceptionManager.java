package br.com.fesa.rotadagasosa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.fesa.rotadagasosa.model.dto.ErrorDTO;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(value = AppException.class)
	public ResponseEntity<ErrorDTO> handleException(AppException ex, WebRequest request){
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(ex.getExceptionMessage(), ex.getCode()), ex.getCode());
	}
	
}
