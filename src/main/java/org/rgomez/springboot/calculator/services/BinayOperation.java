package org.rgomez.springboot.calculator.services;

import java.math.BigDecimal;

/**
 * 
 * Clase que realiza una operación con dos operandos.
 *
 */
public interface BinayOperation {

	public BigDecimal operate(BigDecimal oper1, BigDecimal oper2);

}
