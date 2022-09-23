package org.rgomez.springboot.calculator.api.controllers.impl;

import java.math.BigDecimal;

import org.rgomez.springboot.calculator.api.controllers.service.ApiRestCalculator;
import org.rgomez.springboot.calculator.logger.LoggerTracer;
import org.rgomez.springboot.calculator.request.OperatorEnum;
import org.rgomez.springboot.calculator.response.ResultResponse;
import org.rgomez.springboot.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-23T08:26:44.634Z[GMT]")
@RestController
public class CalculatorController implements ApiRestCalculator {

	@Autowired
	private CalculatorService operationService;

	@Autowired
	private LoggerTracer loggerTracer;

	public ResponseEntity<ResultResponse> operation(
			@Parameter(in = ParameterIn.QUERY, description = "Primer operando de la operación", required = true, schema = @Schema()) @RequestParam(value = "number1", required = true) BigDecimal number1,
			@Parameter(in = ParameterIn.QUERY, description = "Segundo operando de la operación", required = true, schema = @Schema()) @RequestParam(value = "number2", required = true) BigDecimal number2,
			@Parameter(in = ParameterIn.QUERY, description = "Operación a realizar con los operandos", required = true, schema = @Schema()) @RequestParam(value = "operator", required = true) OperatorEnum operator) {
		loggerTracer.trace(String.format(
				"INICIO Endpoint /operations. PARAMETROS: RequestParam number1: %s, number2: %s, operator: %s", number1,
				number2, operator));
		ResultResponse result = operationService.operate(operator, number1, number2);
		loggerTracer.trace(String.format("FIN Endpoint /operations.  RESULTADO: %1$,.4f", result.getResult()));

		return ResponseEntity.ok().body(result);
	}

}
