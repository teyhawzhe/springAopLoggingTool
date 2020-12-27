package com.autolog.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpLogUtils {

	private HttpLogUtils() {
		throw new IllegalStateException("HttpLogUtils class");
	}
	
	public static void before(JoinPoint joinPoint,String message) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info(message);
	}
	
	public static void action(HttpServletRequest request, JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		String className = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		Object[] signatureArgs = joinPoint.getArgs();
		HttpRequestParamLogUtils.handler(logger, className, request, signatureArgs);
	}

	public static void after(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		if (Objects.nonNull(result)) {
			logger.info("response body:");
			if (result instanceof Collection) {
				for (Object index : (Collection) result) {
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
		
		logger.info("end http aop logging");
	
	}
	
	

}
