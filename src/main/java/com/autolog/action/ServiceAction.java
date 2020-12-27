package com.autolog.action;

import org.aspectj.lang.JoinPoint;

public interface ServiceAction{
	
	public void doing(JoinPoint joinPoint);

	public void doing(JoinPoint joinPoint, Object result);
}
