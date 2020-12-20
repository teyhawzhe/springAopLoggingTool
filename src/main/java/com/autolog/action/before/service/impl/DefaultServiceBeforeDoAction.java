package com.autolog.action.before.service.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.before.service.ServiceBeforeDoAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultServiceBeforeDoAction implements ServiceBeforeDoAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.serviceBeforeDoActionImplInit(joinPoint);
	}

}
