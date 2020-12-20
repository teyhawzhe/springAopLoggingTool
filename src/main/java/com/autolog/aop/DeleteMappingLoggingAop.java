package com.autolog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.monitor.after.deleteMapping.DeleteMappingAfterMonitor;
import com.autolog.monitor.before.deleteMapping.DeleteMappingBeforeMonitor;
import com.autolog.properties.AutoLoggerSettingProperties;

@Aspect
public class DeleteMappingLoggingAop {

	@Autowired
	private DeleteMappingBeforeMonitor deleteMappingBeforeMonitor;

	@Autowired
	private DeleteMappingAfterMonitor deleteMappingAfterMonitor;

	@Autowired
	private AutoLoggerSettingProperties monitorSettingProperties;

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
	public void deleteMappingJointPoint() {
	}

	@Before("deleteMappingJointPoint()")
	public void beforePostMapping(JoinPoint joinPoint) {
		if (monitorSettingProperties.isDeleteSwitcher()) {
			deleteMappingBeforeMonitor.start(joinPoint);
			deleteMappingBeforeMonitor.doing(joinPoint);
			deleteMappingBeforeMonitor.end(joinPoint);
		}
	}

	@AfterReturning(pointcut = "deleteMappingJointPoint()", returning = "result")
	public void afterPostMapping(JoinPoint joinPoint, Object result) {
		if (monitorSettingProperties.isDeleteSwitcher()) {
			deleteMappingAfterMonitor.start(joinPoint, result);
			deleteMappingAfterMonitor.doing(joinPoint, result);
			deleteMappingAfterMonitor.end(joinPoint, result);
		}
	}

	@AfterThrowing(pointcut = "deleteMappingJointPoint()", throwing = "throwable")
	public void exceptionExecute(JoinPoint joinPoint, Throwable throwable) {
		exceptionHandler.execution(joinPoint, throwable);
	}

}
