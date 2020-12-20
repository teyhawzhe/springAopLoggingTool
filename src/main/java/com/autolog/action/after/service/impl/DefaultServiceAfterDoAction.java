package com.autolog.action.after.service.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.service.ServiceAfterDoAction;
import com.autolog.utils.InitAfterAction;

public class DefaultServiceAfterDoAction implements ServiceAfterDoAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.afterDoActionInit(joinPoint, result);
	}
}
