package com.autolog.action.before.service.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.before.service.ServiceBeforeStartAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultServiceBeforeStartAction implements ServiceBeforeStartAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.serviceBeforeStartActionImplInit(joinPoint);
	}

}
