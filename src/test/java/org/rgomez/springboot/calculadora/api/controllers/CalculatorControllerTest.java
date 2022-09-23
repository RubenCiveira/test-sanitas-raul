package org.rgomez.springboot.calculadora.api.controllers;

import java.math.BigDecimal;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rgomez.springboot.calculator.SpringbootApplication;
import org.rgomez.springboot.calculator.logger.LoggerTracer;
import org.rgomez.springboot.calculator.request.OperatorEnum;
import org.rgomez.springboot.calculator.response.ResultResponse;
import org.rgomez.springboot.calculator.services.CalculatorService;
import org.rgomez.springboot.calculator.services.impl.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@ComponentScan(basePackages = "org.rgomez.springboot.calculator.api.controllers.impl")
@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = { SpringbootApplication.class, CalculatorServiceImpl.class, LoggerTracer.class })
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CalculatorService calculatorService;

	@Order(1)
	@Test
	public void addition() throws Exception {

		Mockito.when(calculatorService.operate(OperatorEnum.SUMA, new BigDecimal(4), new BigDecimal(3)))
				.thenReturn(new ResultResponse(7));

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("number1", "4");
		params.add("number2", "3");
		params.add("operator", "+");

		String expectedJson = "{\"result\" : 7.0}";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/calculator/operations").params(params))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(expectedJson));
		
	
	}

	@Order(2)
	@Test
	public void substraction() throws Exception {

		Mockito.when(calculatorService.operate(OperatorEnum.RESTA, new BigDecimal(4), new BigDecimal(3)))
				.thenReturn(new ResultResponse(1));

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("number1", "4");
		params.add("number2", "3");
		params.add("operator", "-");

		String expectedJson = "{\"result\" : 1.0}";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/calculator/operations").params(params))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(expectedJson));

	}

}