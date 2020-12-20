package com.autolog.action.after.service.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.service.ServiceAfterStartAction;
import com.autolog.utils.InitAfterAction;

public class DefaultServiceAfterStartAction implements ServiceAfterStartAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.serviceAfterStartActionImplInit(joinPoint, result);
	}

}
