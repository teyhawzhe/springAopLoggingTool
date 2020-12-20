package com.autolog.action.after.deleteMapping.impl;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.after.deleteMapping.DeleteMappingAfterDoAction;
import com.autolog.utils.InitAfterAction;

public class DefaultDeleteMappingAfterDoAction implements DeleteMappingAfterDoAction {


	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		InitAfterAction.afterDoActionInit(joinPoint, result);
	}

}
