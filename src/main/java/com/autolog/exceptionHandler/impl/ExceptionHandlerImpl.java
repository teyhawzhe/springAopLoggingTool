package com.autolog.exceptionHandler.impl;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autolog.exceptionHandler.ExceptionHandler;

public class ExceptionHandlerImpl implements ExceptionHandler {

	@Override
	public void execution(JoinPoint joinPoint, Throwable throwable) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.error("********************Exception Starting********************");
		logger.error(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.error(throwable.getClass().getSimpleName().toString());
		StringWriter stack = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stack));
		logger.error(stack.toString());
		logger.error("********************Exception ENDING********************");
	}

}
