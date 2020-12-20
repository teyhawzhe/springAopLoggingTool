package com.autolog.action;

import org.aspectj.lang.JoinPoint;

public interface AfterAction {
	
	public void doing(JoinPoint joinPoint, Object result);
	
}
