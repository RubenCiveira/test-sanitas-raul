package org.rgomez.springboot.calculator.services.impl;

import java.math.BigDecimal;

import org.rgomez.springboot.calculator.services.BinayOperation;
import org.springframework.stereotype.Service;


/**
 * Clase resta de dos operandos
 *
 */
@Service
public class SubtractionImpl implements BinayOperation {

	@Override
	public BigDecimal operate(BigDecimal numero1, BigDecimal numero2) {
		return numero1.subtract(numero2);
	}
	

}
