package org.rgomez.springboot.calculadora.request;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, OperadorBinarioEnum> {

	@Override
	public OperadorBinarioEnum convert(String source) {
		return OperadorBinarioEnum.getOperation(source);
	}



}
