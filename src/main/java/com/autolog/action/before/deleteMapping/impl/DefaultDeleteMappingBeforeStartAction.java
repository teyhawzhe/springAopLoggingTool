package com.autolog.action.before.deleteMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autolog.action.before.deleteMapping.DeleteMappingBeforeStartAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultDeleteMappingBeforeStartAction implements DeleteMappingBeforeStartAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.deleteMappingBeforeStartActionImplInit(joinPoint);
	}

}
