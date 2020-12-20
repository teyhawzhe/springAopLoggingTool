package com.autolog.utils;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitBeforeAction {

	// before do start init

	public static void deleteMappingBeforeStartActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start before deleteMapping init********************");
	}

	public static void getMappingBeforeStartActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start before getMapping init********************");
	}

	public static void postMappingBeforeStartActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start before postMapping init********************");
	}

	public static void putMappingBeforeStartActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start before putMapping init********************");
	}

	public static void serviceBeforeStartActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************start before service init********************");
	}

	// before do default

	public static void beforeDoActionImplInit(HttpServletRequest request, JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		String className = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		Object[] signatureArgs = joinPoint.getArgs();
		HttpRequestLogHandler.handler(logger, className, request, signatureArgs);
	}

	public static void serviceBeforeDoActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		Object[] ob = joinPoint.getArgs();

		for (Object index : ob) {
			LoggerHandler.print(logger, index);
		}

	}

	// before end init
	public static void deleteMappingBeforeEndActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************end before deleteMapping init********************");

	}

	public static void putMappingBeforeEndActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************end before putMapping init********************");

	}

	public static void getMappingBeforeEndActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************end before getMapping init********************");

	}

	public static void postMappingBeforeEndActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************end before postMapping init********************");

	}

	public static void serviceBeforeEndActionImplInit(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		logger.info("********************end before service init********************");

	}

}
