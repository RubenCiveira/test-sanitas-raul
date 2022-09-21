package org.rgomez.springboot.calculadora.services;

import java.math.BigDecimal;

import org.rgomez.springboot.calculadora.api.exceptions.OperationBadRequestException;
import org.rgomez.springboot.calculadora.request.OperadorBinarioEnum;
import org.rgomez.springboot.calculadora.response.ResultResponse;
import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

@Service
public class operationServiceImpl implements OperationService {

	private static final TracerImpl tracer = new TracerImpl();

	/**
	 * Método que realiza una operación sobre dos números
	 * 
	 * @param operacion
	 * @param number1
	 * @param number2
	 * @return ResultResponse
	 */
	@Override
	public ResultResponse calcular(OperadorBinarioEnum operacion, BigDecimal number1, BigDecimal number2) {

		tracer.trace(String.format("Calculando resultado para : %s %s %s", number1, operacion.getOperacion(), number2));

		switch (operacion) {
		case SUMA:
			return new ResultResponse(number1.add(number2).doubleValue());
		case RESTA:
			return new ResultResponse(number1.subtract(number2).doubleValue());

		default:

			tracer.trace(String.format("Operación no soportada: %s", operacion));
			throw new OperationBadRequestException("Operación no soportada: " + operacion);

		}
	}

}
