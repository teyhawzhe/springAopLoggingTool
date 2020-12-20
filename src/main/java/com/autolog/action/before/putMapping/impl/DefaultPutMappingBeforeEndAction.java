package com.autolog.action.before.putMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.before.putMapping.PutMappingBeforeEndAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultPutMappingBeforeEndAction implements PutMappingBeforeEndAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.putMappingBeforeEndActionImplInit(joinPoint);
	}

}
