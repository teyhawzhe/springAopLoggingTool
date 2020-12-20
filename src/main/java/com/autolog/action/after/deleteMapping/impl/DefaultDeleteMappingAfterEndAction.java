package com.autolog.action.after.deleteMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.deleteMapping.DeleteMappingAfterEndAction;
import com.autolog.utils.InitAfterAction;

public class DefaultDeleteMappingAfterEndAction implements DeleteMappingAfterEndAction {

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.deleteMappingAfterEndActionInit(joinPoint, result);
	}

}
