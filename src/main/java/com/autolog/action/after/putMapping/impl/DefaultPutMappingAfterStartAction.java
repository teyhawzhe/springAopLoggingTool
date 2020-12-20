package com.autolog.action.after.putMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autolog.action.after.putMapping.PutMappingAfterStartAction;
import com.autolog.utils.InitAfterAction;

public class DefaultPutMappingAfterStartAction implements PutMappingAfterStartAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.putMappingAfterStartActionImplInit(joinPoint, result);
	}

}
