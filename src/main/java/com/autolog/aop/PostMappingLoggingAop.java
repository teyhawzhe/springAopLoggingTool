package com.autolog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.monitor.after.postMapping.PostMappingAfterMonitor;
import com.autolog.monitor.before.postMapping.PostMappingBeforeMonitor;
import com.autolog.properties.AutoLoggerSettingProperties;

@Aspect
public class PostMappingLoggingAop {

	@Autowired
	private PostMappingBeforeMonitor postMappingBeforeMonitor;

	@Autowired
	private PostMappingAfterMonitor postMappingAfterMonitor;

	@Autowired
	private AutoLoggerSettingProperties monitorSettingProperties;

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void postMappingJointPoint() {
	}

	@Before("postMappingJointPoint()")
	public void beforePostMapping(JoinPoint joinPoint) {
		if (monitorSettingProperties.isGetSwitcher()) {
			postMappingBeforeMonitor.start(joinPoint);
			postMappingBeforeMonitor.doing(joinPoint);
			postMappingBeforeMonitor.end(joinPoint);
		}
	}

	@AfterReturning(pointcut = "postMappingJointPoint()", returning = "result")
	public void afterPostMapping(JoinPoint joinPoint, Object result) {
		if (monitorSettingProperties.isGetSwitcher()) {
			postMappingAfterMonitor.start(joinPoint, result);
			postMappingAfterMonitor.doing(joinPoint, result);
			postMappingAfterMonitor.end(joinPoint, result);
		}
	}
	
	@AfterThrowing(pointcut ="postMappingJointPoint()", throwing = "throwable")
	public void exceptionExecute(JoinPoint joinPoint, Throwable throwable){
		exceptionHandler.execution(joinPoint, throwable);
	}

}
