package org.rgomez.springboot.calculadora.request;

public enum Operador {
	SUMA("+", "Operación aritmetica para sumar dos números"),
	RESTA("-", "Operación aritmetica para restar dos números");
	/* TODO añadir más operaciones en el futuro */

	private static final Operador[] operaciones = new Operador[] { SUMA, RESTA };

	private String operacion;

	private String descripcion;

	Operador(String operacion, String descripcion) {
		this.operacion = operacion;
		this.descripcion = descripcion;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}