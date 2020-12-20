package com.autolog.action.after.service.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.service.ServiceAfterEndAction;
import com.autolog.utils.InitAfterAction;

public class DefaultServiceAfterEndAction implements ServiceAfterEndAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.serviceAfterEndActionInit(joinPoint, result);
	}

}
