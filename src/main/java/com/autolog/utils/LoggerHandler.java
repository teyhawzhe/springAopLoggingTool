package com.autolog.utils;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;

public class LoggerHandler {

	public static void print(Logger logger , Object ob ) {
		ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);
		logger.info(ReflectionToStringBuilder.toString(ob));
	}
	
}
