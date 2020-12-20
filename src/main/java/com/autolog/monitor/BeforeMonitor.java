package com.autolog.monitor;

import org.aspectj.lang.JoinPoint;

public interface BeforeMonitor {
	
	public void start(JoinPoint joinPoint);

	public void doing(JoinPoint joinPoint);

	public void end(JoinPoint joinPoint);
}
