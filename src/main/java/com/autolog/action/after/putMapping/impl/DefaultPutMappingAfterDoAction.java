package com.autolog.action.after.putMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.putMapping.PutMappingAfterDoAction;
import com.autolog.utils.InitAfterAction;

public class DefaultPutMappingAfterDoAction implements PutMappingAfterDoAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.afterDoActionInit( joinPoint, result);
	}

}
