package org.rgomez.springboot.calculator.services;

import java.math.BigDecimal;

import org.rgomez.springboot.calculator.request.OperatorEnum;
import org.rgomez.springboot.calculator.response.ResultResponse;

public interface CalculatorService {

	/**
	 * Método que realiza una operación sobre dos números y un operando
	 * 
	 * @param operacion
	 * @param number1
	 * @param number2
	 * @return ResultResponse
	 */
	ResultResponse operate(OperatorEnum operacion, BigDecimal number1, BigDecimal number2);

}
