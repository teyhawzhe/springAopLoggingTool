package com.autolog.action.before.getMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autolog.action.before.getMapping.GetMappingBeforeStartAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultGetMappingBeforeStartAction implements GetMappingBeforeStartAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.getMappingBeforeStartActionImplInit(joinPoint);
	}

}
