package com.autolog.exceptionHandler;

import org.aspectj.lang.JoinPoint;

public interface ExceptionHandler {
	public void execution(JoinPoint joinPoint, Throwable throwable);
}
