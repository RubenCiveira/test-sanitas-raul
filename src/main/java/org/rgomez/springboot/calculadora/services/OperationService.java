package org.rgomez.springboot.calculadora.services;

import org.rgomez.springboot.calculadora.request.Operador;
import org.rgomez.springboot.calculadora.response.ResultResponse;

public interface OperationService {

	/**
	 * Método que realiza una operación sobre dos nímeros
	 * 
	 * @param operacion
	 * @param number1
	 * @param number2
	 * @return ResultResponse
	 */
	ResultResponse calcular(Operador operacion, double number1, double number2);

}
