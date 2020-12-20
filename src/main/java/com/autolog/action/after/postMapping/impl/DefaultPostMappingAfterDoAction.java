package com.autolog.action.after.postMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.postMapping.PostMappingAfterDoAction;
import com.autolog.utils.InitAfterAction;

public class DefaultPostMappingAfterDoAction implements PostMappingAfterDoAction {

	
	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.afterDoActionInit(joinPoint, result);
	}

}
