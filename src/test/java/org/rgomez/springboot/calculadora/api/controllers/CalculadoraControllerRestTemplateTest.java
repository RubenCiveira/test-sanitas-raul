package org.rgomez.springboot.calculadora.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.rgomez.springboot.calculadora.response.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculadoraControllerRestTemplateTest {

	@Autowired
	private TestRestTemplate client;

	@LocalServerPort
	private int puerto;

	@Test
	@Order(1)
	void testSuma() {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("number1", "4");
		params.add("number2", "3");
		params.add("operator", "SUMA");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(crearUri("/api/calculator/operations"))
				.queryParams(params);
		ResponseEntity<ResultResponse> response = client.getForEntity(builder.toUriString(), ResultResponse.class);
		System.out.println(puerto);
		ResultResponse precioResult = response.getBody();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		assertNotNull(precioResult);
		assertEquals(7, precioResult.getResult());

	}

	@Test
	@Order(2)
	void testResta() {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("number1", "4");
		params.add("number2", "3");
		params.add("operator", "-");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(crearUri("/api/calculator/operations"))
				.queryParams(params);
		ResponseEntity<ResultResponse> response = client.getForEntity(builder.toUriString(), ResultResponse.class);
		System.out.println(puerto);
		ResultResponse result = response.getBody();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		assertNotNull(result);
		assertEquals(1, result.getResult());
	}

	@Test
	@Order(3)
	void testOperacionNoPermitida() {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("number1", "4");
		params.add("number2", "3");
		params.add("operator", "DESCONOCIDA");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(crearUri("/api/calculator/operations"))
				.queryParams(params);

		ResponseEntity<ResultResponse> response = client.getForEntity(builder.toUriString(), ResultResponse.class);		
		System.out.println(puerto);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	
	
	}

	private String crearUri(String uri) {
		return "http://localhost:" + puerto + uri;
	}
}