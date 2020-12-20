package com.autolog.action.before.getMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.before.getMapping.GetMappingBeforeEndAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultGetMappingBeforeEndAction implements GetMappingBeforeEndAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.getMappingBeforeEndActionImplInit(joinPoint);
		
	}

}
