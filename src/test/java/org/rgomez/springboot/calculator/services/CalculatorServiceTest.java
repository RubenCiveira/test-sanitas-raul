package org.rgomez.springboot.calculator.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rgomez.springboot.calculator.logger.LoggerTracer;
import org.rgomez.springboot.calculator.request.OperatorEnum;
import org.rgomez.springboot.calculator.response.ResultResponse;
import org.rgomez.springboot.calculator.services.impl.CalculatorServiceImpl;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

	@InjectMocks
	CalculatorService calculatorService = new CalculatorServiceImpl();
	@Mock
	LoggerTracer loggerTracer;

	@DisplayName("Test suma ok")
	@Test
	void sumaOk() {
		ResultResponse responseTest = new ResultResponse(5);

		ResultResponse response = calculatorService.operate(OperatorEnum.SUMA, new BigDecimal(3), new BigDecimal(2));

		verify(loggerTracer).trace("Calculando resultado para : 3 + 2");
		assertEquals(responseTest, response);
	}

	@DisplayName("Test resta ok")
	@Test
	void restaOk() {
		ResultResponse responseTest = new ResultResponse(1);

		ResultResponse response = calculatorService.operate(OperatorEnum.RESTA, new BigDecimal(3), new BigDecimal(2));
		
		verify(loggerTracer).trace("Calculando resultado para : 3 - 2");
		assertEquals(responseTest, response);
	}

}
