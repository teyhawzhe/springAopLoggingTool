package com.autolog.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;

public class ExceptionPrintHandler {

	public static void handler(Logger logger,Throwable throwable) {
		StringWriter stack = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stack));
		logger.error(stack.toString());
	}
	
}
