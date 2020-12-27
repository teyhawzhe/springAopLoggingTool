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

import com.autolog.action.HttpsAction;
import com.autolog.action.ThreadLocalInterceptor;
import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.properties.AutoLoggerSettingProperties;
import com.autolog.properties.TheadLocalProperties;

@Aspect
public class RequestLoggingAop {

	@Autowired
	private AutoLoggerSettingProperties autoLoggerSettingProperties;

	@Autowired
	private TheadLocalProperties theadLocalProperties;

	@Autowired
	private ThreadLocalInterceptor threadLocalInterceptor;

	@Autowired
	private List<HttpsAction> httpsAction;

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void getMappingJointPoint() {
	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void postMappingJointPoint() {
	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
	public void deleteMappingJointPoint() {
	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
	public void putMappingJointPoint() {
	}

	@Before("getMappingJointPoint() || postMappingJointPoint() || putMappingJointPoint() || deleteMappingJointPoint()")
	public void beforeRequest(JoinPoint joinPoint) {
		ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);

		//if (theadLocalProperties.isEnable()) {
			threadLocalInterceptor.action(joinPoint);
		//}

		if (autoLoggerSettingProperties.isHttpsSwitcher()) {
			for (HttpsAction action : httpsAction) {
				action.doing(joinPoint);
			}
		}
	}

	@AfterReturning(pointcut = "getMappingJointPoint() || postMappingJointPoint() || putMappingJointPoint() || deleteMappingJointPoint()", returning = "result")
	public void afterRequest(JoinPoint joinPoint, Object result) {
		if (autoLoggerSettingProperties.isHttpsSwitcher()) {
			for (HttpsAction action : httpsAction) {
				action.doing(joinPoint, result);
			}
		}
	}

	@AfterThrowing(pointcut = "getMappingJointPoint() || postMappingJointPoint() || putMappingJointPoint() || deleteMappingJointPoint()", throwing = "throwable")
	public void exceptionExecute(JoinPoint joinPoint, Throwable throwable) {
		exceptionHandler.execution(joinPoint, throwable);
	}

}
