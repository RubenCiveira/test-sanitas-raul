package org.rgomez.springboot.calculator.services.impl;

import java.math.BigDecimal;

import org.rgomez.springboot.calculator.api.exceptions.OperationBadRequestException;
import org.rgomez.springboot.calculator.logger.LoggerTracer;
import org.rgomez.springboot.calculator.request.OperatorEnum;
import org.rgomez.springboot.calculator.response.ResultResponse;
import org.rgomez.springboot.calculator.services.BinayOperation;
import org.rgomez.springboot.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	private LoggerTracer loggerTracer;

	/**
	 * Método que realiza una operación sobre dos números
	 * 
	 * @param operation
	 * @param number1
	 * @param number2
	 * @return ResultResponse
	 */
	@Override
	public ResultResponse operate(OperatorEnum operation, BigDecimal number1, BigDecimal number2) {

		loggerTracer.trace(
				String.format("Calculando resultado para : %s %s %s", number1, operation.getOperacion(), number2));

		BinayOperation binayOperation = operationSelector(operation);

		return new ResultResponse(binayOperation.operate(number1, number2).doubleValue());

	}

	/**
	 * Método que selecciona operación a realizar
	 * 
	 * @param operation
	 * @return BinayOperation
	 */
	private BinayOperation operationSelector(OperatorEnum operation) {

		switch (operation) {
		case SUMA:
			return new AdditionImpl();
		case RESTA:
			return new SubtractionImpl();

		default:
			loggerTracer.trace(String.format("Operación no soportada: %s", operation));
			throw new OperationBadRequestException("Operación no soportada: " + operation);
		}
	}

}
