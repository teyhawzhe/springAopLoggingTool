package com.autolog.action.after.getMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.getMapping.GetMappingAfterDoAction;
import com.autolog.utils.InitAfterAction;

public class DefaultGetMappingAfterDoAction implements GetMappingAfterDoAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.afterDoActionInit(joinPoint, result);
	}

}
