package org.rgomez.springboot.calculadora.request;

import org.rgomez.springboot.calculadora.api.exceptions.OperationBadRequestException;

import io.corp.calculator.TracerImpl;
import lombok.Getter;

@Getter
public enum OperadorBinarioEnum {
	SUMA("+", "Operación aritmetica para sumar dos números"),
	RESTA("-", "Operación aritmetica para restar dos números");
	/* TODO añadir más operaciones en el futuro */

	private static final OperadorBinarioEnum[] operaciones = new OperadorBinarioEnum[] { SUMA, RESTA };

	private String operacion;

	private String descripcion;
	
	private static final TracerImpl tracer = new TracerImpl();


	/**
	 * 
	 * @param value
	 * @return operador
	 */
	public static OperadorBinarioEnum getOperation(String value) {

		for (OperadorBinarioEnum operador : operaciones) {
			if (value.equalsIgnoreCase(operador.name()) || value.equalsIgnoreCase(operador.getOperacion())) {
				return operador;
			}
		}
		tracer.trace(String.format("Operación no soportada: %s", value));
		throw new OperationBadRequestException("Operación no soportada: " + value);
	}

	private OperadorBinarioEnum(String operacion, String descripcion) {
		this.operacion = operacion;
		this.descripcion = descripcion;
	}
}