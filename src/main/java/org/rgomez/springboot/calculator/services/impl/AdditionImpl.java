package org.rgomez.springboot.calculator.services.impl;

import java.math.BigDecimal;

import org.rgomez.springboot.calculator.services.BinayOperation;
import org.springframework.stereotype.Service;

/**
 * Clase suma de dos operandos.
 *
 */
@Service
public class AdditionImpl implements BinayOperation {

	@Override
	public BigDecimal operate(BigDecimal number1, BigDecimal number2) {

		return number1.add(number2);
	}

}
