package com.autolog.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLogUtils {

	private ServiceLogUtils() {
		throw new IllegalStateException("ServiceLogUtils class");
	}

	public static void before(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		Object[] ob = joinPoint.getArgs();

		for (Object index : ob) {
			LoggerUtils.print(logger, index);
		}

	}

	public static void after(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		if (Objects.nonNull(result)) {
			logger.info("service output:");
			if (result instanceof Collection) {
				for (Object index : (Collection<?>) result) {
					LoggerUtils.print(logger, index);
				}
			} else if (result instanceof Map) {
				for (Entry<String, Object> entry : ((Map<String, Object>) result).entrySet()) {
					LoggerUtils.print(logger, entry);
				}
			} else {
				LoggerUtils.print(logger, result);
			}
		}
	}

}
