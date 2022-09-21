package org.rgomez.springboot.calculadora.api.controllers;

import org.rgomez.springboot.calculadora.request.Operador;
import org.rgomez.springboot.calculadora.response.ResultResponse;
import org.rgomez.springboot.calculadora.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@Operation(summary = "Resultado operación", description = "Resultado operación", tags = { "Operations" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Consulta correcta"),
			@ApiResponse(responseCode = "400", description = "Error en la petición"),
			@ApiResponse(responseCode = "500", description = "Error interno en el servidor") })
	@GetMapping(path = "/operations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> precio(@RequestParam(required = true, name = "operator") Operador operacion,
			@RequestParam(required = true, name = "number1") double number1,
			@RequestParam(required = true, name = "number2") double number2) {

		ResultResponse result = operationService.calcular(operacion, number1, number2);

		return ResponseEntity.ok().body(result);

	}

}
