package com.autolog.action.after.postMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.postMapping.PostMappingAfterStartAction;
import com.autolog.utils.InitAfterAction;

public class DefaultPostMappingAfterStartAction implements PostMappingAfterStartAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.postMappingAfterStartActionImplInit(joinPoint, result);
	}

}
