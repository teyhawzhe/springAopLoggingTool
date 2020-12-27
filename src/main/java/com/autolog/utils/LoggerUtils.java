package com.autolog.utils;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;

public class LoggerUtils {

	private LoggerUtils() {
		throw new IllegalStateException("LoggerUtils class");
	}
	
	public static void print(Logger logger , Object ob ) {
		logger.info(ReflectionToStringBuilder.toString(ob));
	}
	
	public static void print(Logger logger , Object ob ,String message) {
		logger.info("{}:{}",message,ReflectionToStringBuilder.toString(ob));
	}
	
}
