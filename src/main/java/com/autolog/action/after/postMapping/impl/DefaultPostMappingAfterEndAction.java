package com.autolog.action.after.postMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.postMapping.PostMappingAfterEndAction;
import com.autolog.utils.InitAfterAction;

public class DefaultPostMappingAfterEndAction implements PostMappingAfterEndAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.postMappingAfterEndActionInit(joinPoint, result);
	}

}
