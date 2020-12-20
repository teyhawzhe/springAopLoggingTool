package com.autolog.action;

import org.aspectj.lang.JoinPoint;

public interface BeforeAction {
	
	public void doing(JoinPoint joinPoint);
	
}
