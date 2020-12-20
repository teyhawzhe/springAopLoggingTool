package com.autolog.action.after.getMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.getMapping.GetMappingAfterEndAction;
import com.autolog.utils.InitAfterAction;

public class DefaultGetMappingAfterEndAction implements GetMappingAfterEndAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.getMappingAfterEndActionInit(joinPoint, result);
	}

}
