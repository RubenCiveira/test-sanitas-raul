package org.rgomez.springboot.calculadora.api.exceptions;

public class OperationErrorDatosException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3021073742073521004L;

	public OperationErrorDatosException(String msg) {
		super(msg);
	}

	public OperationErrorDatosException(Throwable t) {
		super(t);
	}

	public OperationErrorDatosException(String msg, Throwable t) {
		super(msg, t);
	}
}
