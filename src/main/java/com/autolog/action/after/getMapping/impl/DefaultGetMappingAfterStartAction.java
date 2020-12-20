package com.autolog.action.after.getMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.getMapping.GetMappingAfterStartAction;
import com.autolog.utils.InitAfterAction;

public class DefaultGetMappingAfterStartAction implements GetMappingAfterStartAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.getMappingAfterStartActionImplInit(joinPoint, result);
	}

}
