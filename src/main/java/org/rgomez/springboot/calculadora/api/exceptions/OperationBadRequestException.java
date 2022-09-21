package org.rgomez.springboot.calculadora.api.exceptions;

public class OperationBadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8667375163476369227L;

	public OperationBadRequestException(String msg) {
		super(msg);
	}
	
	public OperationBadRequestException(Throwable t) {
		super(t);
	}

	public OperationBadRequestException(String msg, Throwable t) {
		super(msg, t);
	}
}
