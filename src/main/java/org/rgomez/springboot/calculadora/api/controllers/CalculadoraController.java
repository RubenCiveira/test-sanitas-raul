package org.rgomez.springboot.calculadora.api.controllers;

import java.math.BigDecimal;

import org.rgomez.springboot.calculadora.request.OperadorBinarioEnum;
import org.rgomez.springboot.calculadora.response.ResultResponse;
import org.rgomez.springboot.calculadora.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * Controlador Rest donde se definen las operaciones.
 * 
 * @author raul.gomezillan
 *
 */

@OpenAPIDefinition(info = @Info(title = "Calculadora API", version = "0.0.1", description = "Calculadora de operaciones con dos operandos"), tags = {
		@Tag(name = "Operations") })

@RestController
@RequestMapping("/api/calculator")
public class CalculadoraController {

	@Autowired
	private OperationService operationService;

	private static final TracerImpl tracer = new TracerImpl();

	@Operation(summary = "Resultado operación", description = "Resultado operación", tags = { "Operations" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Consulta correcta"),
			@ApiResponse(responseCode = "400", description = "Error en la petición"),
			@ApiResponse(responseCode = "500", description = "Error interno en el servidor") })
	@GetMapping(path = "/operations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> precio(
			@RequestParam(required = true, name = "operator") OperadorBinarioEnum operacion,
			@RequestParam(required = true, name = "number1") BigDecimal number1,
			@RequestParam(required = true, name = "number2") BigDecimal number2) {

		tracer.trace(String.format(
				"INICIO Endpoint /operations. PARAMETROS: RequestParam number1: %s, number2: %s, operator: %s", number1,
				number2, operacion));
		ResultResponse result = operationService.calcular(operacion, number1, number2);
		tracer.trace(String.format("FIN Endpoint /operations.  RESULTADO: %1$,.4f", result.getResult()));

		return ResponseEntity.ok().body(result);

	}

}
