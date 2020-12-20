package com.autolog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.threadLocalInterceptor.ThreadLocalInterceptor;
import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.monitor.after.getMapping.GetMappingAfterMonitor;
import com.autolog.monitor.before.getMapping.GetMappingBeforeMonitor;
import com.autolog.properties.AutoLoggerSettingProperties;

@Aspect
public class GetMappingLoggingAop {

	@Autowired
	private GetMappingBeforeMonitor getMappingBeforeMonitor;

	@Autowired
	private GetMappingAfterMonitor getMappingAfterMonitor;

	@Autowired
	private AutoLoggerSettingProperties monitorSettingProperties;

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Autowired
	private ThreadLocalInterceptor threadLocalInterceptor;
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void getMappingJointPoint() {
	}

	@Before("getMappingJointPoint()")
	public void beforeGetMapping(JoinPoint joinPoint) {

		if (monitorSettingProperties.isGetSwitcher()) {
			threadLocalInterceptor.action(joinPoint);
			getMappingBeforeMonitor.start(joinPoint);
			getMappingBeforeMonitor.doing(joinPoint);
			getMappingBeforeMonitor.end(joinPoint);
		}
	}

	@AfterReturning(pointcut = "getMappingJointPoint()", returning = "result")
	public void afterGetMapping(JoinPoint joinPoint, Object result) {
		if (monitorSettingProperties.isGetSwitcher()) {
			getMappingAfterMonitor.start(joinPoint, result);
			getMappingAfterMonitor.doing(joinPoint, result);
			getMappingAfterMonitor.end(joinPoint, result);
		}
	}

	@AfterThrowing(pointcut = "getMappingJointPoint()", throwing = "throwable")
	public void exceptionExecute(JoinPoint joinPoint, Throwable throwable) {
		exceptionHandler.execution(joinPoint, throwable);
	}

}
