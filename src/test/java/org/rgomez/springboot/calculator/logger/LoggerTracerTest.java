package org.rgomez.springboot.calculator.logger;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.corp.calculator.TracerImpl;

@ExtendWith(MockitoExtension.class)
class LoggerTracerTest {

	@InjectMocks
	LoggerTracer loggerTracer = new LoggerTracer();

	@Mock
	TracerImpl tracerImpl;

	@DisplayName("Test suma ok")
	@Test
	void test() {
		loggerTracer.trace("Comntario test");
		verify(tracerImpl).trace("Comntario test");
	}

}
