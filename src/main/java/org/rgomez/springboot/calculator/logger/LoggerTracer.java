package org.rgomez.springboot.calculator.logger;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Component;

@Component
public class LoggerTracer implements TracerAPI {

	private TracerImpl tracerImpl;

	public LoggerTracer() {
		this.tracerImpl = new TracerImpl();
	}

	private TracerImpl getTracerImpl() {
		return tracerImpl == null ? tracerImpl = new TracerImpl() : tracerImpl;
	}

	@Override
	public <T> void trace(T arg0) {
		getTracerImpl().trace(arg0);
	}
}
