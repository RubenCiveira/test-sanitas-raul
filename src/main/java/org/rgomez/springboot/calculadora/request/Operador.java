package org.rgomez.springboot.calculadora.request;

import org.rgomez.springboot.calculadora.api.exceptions.OperationBadRequestException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Operador {
	SUMA("+", "Operación aritmetica para sumar dos números"),
	RESTA("-", "Operación aritmetica para restar dos números");
	/* TODO añadir más operaciones en el futuro */

	private static final Operador[] operaciones = new Operador[] { SUMA, RESTA };

	private String operacion;

	private String descripcion;

	/**
	 * 
	 * @param value
	 * @return operador
	 */
	public static Operador getOperation(String value) {

		for (Operador operador : operaciones) {
			if (value.equalsIgnoreCase(operador.name()) || value.equalsIgnoreCase(operador.getOperacion())) {
				return operador;
			}
		}
		throw new OperationBadRequestException("Operación no soportada: " + value);
	}
}