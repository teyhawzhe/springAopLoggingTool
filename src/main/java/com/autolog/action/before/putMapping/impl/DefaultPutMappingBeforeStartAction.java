package com.autolog.action.before.putMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autolog.action.before.putMapping.PutMappingBeforeStartAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultPutMappingBeforeStartAction implements PutMappingBeforeStartAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.putMappingBeforeStartActionImplInit(joinPoint);
	}

}
