package org.rgomez.springboot.calculator.request;

import java.util.Optional;

import org.rgomez.springboot.calculator.api.exceptions.OperationBadRequestException;
import org.rgomez.springboot.calculator.logger.LoggerTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, OperatorEnum> {

	@Autowired
	private LoggerTracer loggerTracer;

	@Override
	public OperatorEnum convert(String source) {
		Optional<OperatorEnum> binaryOperatorEnumOpt = OperatorEnum.getOperation(source);

		if (!binaryOperatorEnumOpt.isPresent()) {
			loggerTracer.trace(String.format("Operación no soportada: %s", source));
			throw new OperationBadRequestException("Operación no soportada: " + source);
		}

		return binaryOperatorEnumOpt.get();
	}

}
