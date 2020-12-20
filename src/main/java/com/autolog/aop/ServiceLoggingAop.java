package com.autolog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.monitor.after.service.ServiceAfterMonitor;
import com.autolog.monitor.before.service.ServiceBeforeMonitor;
import com.autolog.properties.AutoLoggerSettingProperties;

@Aspect
public class ServiceLoggingAop {

	@Autowired
	private ServiceBeforeMonitor serviceBeforeMonitor;

	@Autowired
	private ServiceAfterMonitor serviceAfterMonitor;

	@Autowired
	private AutoLoggerSettingProperties monitorSettingProperties;

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Pointcut("@within(org.springframework.stereotype.Service)")
	public void serviceJointPoint() {
	}

	@Before("serviceJointPoint()")
	public void beforeService(JoinPoint joinPoint) {
		if (monitorSettingProperties.isGetSwitcher()) {
			serviceBeforeMonitor.start(joinPoint);
			serviceBeforeMonitor.doing(joinPoint);
			serviceBeforeMonitor.end(joinPoint);
		}
	}

	@AfterReturning(pointcut = "serviceJointPoint()", returning = "result")
	public void afterService(JoinPoint joinPoint, Object result) {
		if (monitorSettingProperties.isGetSwitcher()) {
			serviceAfterMonitor.start(joinPoint, result);
			serviceAfterMonitor.doing(joinPoint, result);
			serviceAfterMonitor.end(joinPoint, result);
		}
	}
	
	@AfterThrowing(pointcut ="serviceJointPoint()", throwing = "throwable")
	public void exceptionExecute(JoinPoint joinPoint, Throwable throwable){
		exceptionHandler.execution(joinPoint, throwable);
	}

}
