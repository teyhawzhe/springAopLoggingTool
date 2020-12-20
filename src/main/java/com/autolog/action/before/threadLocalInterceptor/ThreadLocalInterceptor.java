package com.autolog.action.before.threadLocalInterceptor;

import org.aspectj.lang.JoinPoint;

public interface ThreadLocalInterceptor {
	public void action(JoinPoint joinPoint);
}
