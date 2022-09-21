package org.rgomez.springboot.calculadora.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * Clase manejadora de errores.
 * 
 * @author raul.gomezillan
 *
 */
@ControllerAdvice
public class OperationAdvice {

	@ResponseBody
	@ExceptionHandler(OperationBadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String operationBadRequestHandler(OperationBadRequestException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(OperationErrorDatosException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String operationErrorDatosRequestHandler(OperationErrorDatosException ex) {
		return ex.getMessage();
	}

}
