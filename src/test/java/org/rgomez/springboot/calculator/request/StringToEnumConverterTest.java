package org.rgomez.springboot.calculator.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rgomez.springboot.calculator.api.exceptions.OperationBadRequestException;
import org.rgomez.springboot.calculator.logger.LoggerTracer;

@ExtendWith(MockitoExtension.class)
class StringToEnumConverterTest {
	@InjectMocks
	StringToEnumConverter converter = new StringToEnumConverter();

	@Mock
	LoggerTracer loggerTracer;

	@DisplayName("Test value = SUMA")
	@Test
	void testSumaMayus() {
		OperatorEnum result = converter.convert("SUMA");
		assertEquals(OperatorEnum.SUMA, result);
	}

	@DisplayName("Test value = suma")
	@Test
	void testSumaMinus() {
		OperatorEnum result = converter.convert("suma");
		assertEquals(OperatorEnum.SUMA, result);
	}

	@DisplayName("Test value = suma")
	@Test
	void testSumaSimbolo() {
		OperatorEnum result = converter.convert("+");
		assertEquals(OperatorEnum.SUMA, result);
	}

	@DisplayName("Test value = RESTA")
	@Test
	void testRestaMayus() {
		OperatorEnum result = converter.convert("RESTA");
		assertEquals(OperatorEnum.RESTA, result);
	}

	@DisplayName("Test value = resta")
	@Test
	void testRestaMinus() {
		OperatorEnum result = converter.convert("resta");
		assertEquals(OperatorEnum.RESTA, result);
	}

	@DisplayName("Test value = -")
	@Test
	void testRestaSimbolo() {
		OperatorEnum result = converter.convert("-");
		assertEquals(OperatorEnum.RESTA, result);
	}

	@DisplayName("Test value desconocido")
	@Test
	void testRestaDesconocido() {

		OperationBadRequestException badRequestException = assertThrows(OperationBadRequestException.class,
				() -> converter.convert("desconocido"));
		verify(loggerTracer).trace("Operación no soportada: desconocido");

		assertEquals("Operación no soportada: desconocido", badRequestException.getMessage());
	}

}
