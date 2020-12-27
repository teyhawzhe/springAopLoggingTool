package com.autolog.aop;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.ServiceAction;
import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.properties.AutoLoggerSettingProperties;

@Aspect
public class ServiceLoggingAop {

	@Autowired
	private AutoLoggerSettingProperties autoLoggerSettingProperties;

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Autowired
	private List<ServiceAction> serviceAction;
	
	@Pointcut("@within(org.springframework.stereotype.Service)")
	public void serviceJointPoint() {
	}

	@Before("serviceJointPoint()")
	public void beforeService(JoinPoint joinPoint) {
		if(autoLoggerSettingProperties.isServiceSwitcher()) {
			ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);
			for(ServiceAction action:serviceAction) {
				action.doing(joinPoint);
			}
		}
	}

	@AfterReturning(pointcut = "serviceJointPoint()", returning = "result")
	public void afterService(JoinPoint joinPoint, Object result) {
		if(autoLoggerSettingProperties.isServiceSwitcher()) {
			for(ServiceAction action:serviceAction) {
				action.doing(joinPoint,result);
			}
		}
	}

	@AfterThrowing(pointcut = "serviceJointPoint()", throwing = "throwable")
	public void exceptionExecute(JoinPoint joinPoint, Throwable throwable) {
		exceptionHandler.execution(joinPoint, throwable);
	}

}
