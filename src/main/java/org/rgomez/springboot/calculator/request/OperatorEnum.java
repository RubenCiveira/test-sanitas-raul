package org.rgomez.springboot.calculator.request;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.Getter;

/**
 * 
 * @author raul.gomezillan
 *
 */
@Getter
public enum OperatorEnum {
	SUMA("+", "Operación aritmetica para sumar dos números"),
	RESTA("-", "Operación aritmetica para restar dos números");
	/* TODO añadir más operaciones en el futuro */

	private static final List<OperatorEnum> operations = Arrays.asList(SUMA, RESTA);

	private String operacion;

	private String descripcion;

	/**
	 * 
	 * @param value
	 * @return operador
	 */
	public static Optional<OperatorEnum> getOperation(String value) {

		return operations.stream().filter(operador -> (value.equalsIgnoreCase(operador.name())
				|| value.equalsIgnoreCase(operador.getOperacion()))).findFirst();

	}

	private OperatorEnum(String operacion, String descripcion) {
		this.operacion = operacion;
		this.descripcion = descripcion;
	}
}