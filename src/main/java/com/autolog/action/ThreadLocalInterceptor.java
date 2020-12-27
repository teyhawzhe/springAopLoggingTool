package com.autolog.action;

import org.aspectj.lang.JoinPoint;

public interface ThreadLocalInterceptor {
	public void action(JoinPoint joinPoint);
}
