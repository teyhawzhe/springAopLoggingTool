package com.autolog.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitAfterAction {

	// after start init

	public static void deleteMappingAfterStartActionImplInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start after deleteMapping init********************");
		logger.info(
				"class=>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	public static void getMappingAfterStartActionImplInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start after getMapping init********************");
	}

	public static void postMappingAfterStartActionImplInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start after postMapping init********************");
		logger.info(
				"class=>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	public static void putMappingAfterStartActionImplInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start after putMapping init********************");
		logger.info(
				"class=>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	public static void serviceAfterStartActionImplInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start after service init********************");
		logger.info(
				"class=>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	}

	// after do action init

	public static void afterDoActionInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		if (Objects.nonNull(result)) {
			if (result instanceof Collection) {
				for (Object index : (Collection) result) {
					LoggerHandler.print(logger, index);
				}
			} else if (result instanceof Map) {
				for (Entry<String, Object> entry : ((Map<String, Object>) result).entrySet()) {
					LoggerHandler.print(logger, entry);
				}
			} else {
				LoggerHandler.print(logger, result);
			}
		}
	}

	// after end init

	public static void postMappingAfterEndActionInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************after postMapping ending********************");
	}

	public static void putMappingAfterEndActionInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************after putMapping ending********************");
	}

	public static void deleteMappingAfterEndActionInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************after deleteMapping ending********************");
	}

	public static void getMappingAfterEndActionInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************after getMapping ending********************");
	}

	public static void serviceAfterEndActionInit(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************after service ending********************");
	}

}
