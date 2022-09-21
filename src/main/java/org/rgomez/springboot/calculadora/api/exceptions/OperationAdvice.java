package org.rgomez.springboot.calculadora.api.exceptions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * Clase manejadora de errores.
 * 
 * @author raul.gomezillan
 *
 */
@ControllerAdvice
public class OperationAdvice {

	

	@ExceptionHandler(OperationBadRequestException.class)
	public final ResponseEntity<Object> operationErrorDatosRequestHandler(OperationBadRequestException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "Error en la request");
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "Número con formato incorrecto");
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(ConversionFailedException.class)
	public final ResponseEntity<Object> handleConversionFailedException(ConversionFailedException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "Operación no soportada");
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

}
