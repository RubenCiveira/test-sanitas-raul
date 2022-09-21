package org.rgomez.springboot.calculadora.request;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Operador> {

	@Override
	public Operador convert(String source) {
		return Operador.getOperation(source);
	}



}
