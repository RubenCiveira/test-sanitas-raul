package org.rgomez.springboot.calculadora.services;

import java.math.BigDecimal;

import org.rgomez.springboot.calculadora.api.exceptions.OperationBadRequestException;
import org.rgomez.springboot.calculadora.request.Operador;
import org.rgomez.springboot.calculadora.response.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class operationServiceImpl implements OperationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(operationServiceImpl.class);

	/**
	 * Método que realiza una operación sobre dos nímeros
	 * 
	 * @param operacion
	 * @param number1
	 * @param number2
	 * @return ResultResponse
	 */
	@Override
	public ResultResponse calcular(Operador operacion, BigDecimal number1, BigDecimal number2) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Calculando resultado para : {} {} {}", number1, operacion, number2);
		}

		switch (operacion) {
		case SUMA:
			return new ResultResponse(number1.add(number2).doubleValue());
		case RESTA:
			return new ResultResponse(number1.subtract(number2).doubleValue());

		default:
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("Operación no soportada: {}", operacion);
			}
			throw new OperationBadRequestException("Operación no soportada: " + operacion);

		}
	}

}
