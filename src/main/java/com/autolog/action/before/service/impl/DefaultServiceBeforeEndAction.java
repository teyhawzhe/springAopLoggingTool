package com.autolog.action.before.service.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.before.service.ServiceBeforeEndAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultServiceBeforeEndAction implements ServiceBeforeEndAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.serviceBeforeEndActionImplInit(joinPoint);
	}

}
