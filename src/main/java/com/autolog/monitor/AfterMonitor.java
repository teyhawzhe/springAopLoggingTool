package com.autolog.monitor;

import org.aspectj.lang.JoinPoint;

public interface AfterMonitor {
	
	public void start(JoinPoint joinPoint, Object result);

	public void doing(JoinPoint joinPoint, Object result);

	public void end(JoinPoint joinPoint, Object result);
}
