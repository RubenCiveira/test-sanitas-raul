package org.rgomez.springboot.calculadora.services;

import java.math.BigDecimal;

import org.rgomez.springboot.calculadora.request.OperadorBinarioEnum;
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
	ResultResponse calcular(OperadorBinarioEnum operacion, BigDecimal number1, BigDecimal number2);

}
