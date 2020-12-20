package com.autolog.action.after.deleteMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.deleteMapping.DeleteMappingAfterStartAction;
import com.autolog.utils.InitAfterAction;

public class DefaultDeleteMappingAfterStartAction implements DeleteMappingAfterStartAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.deleteMappingAfterStartActionImplInit(joinPoint, result);
	}

}
