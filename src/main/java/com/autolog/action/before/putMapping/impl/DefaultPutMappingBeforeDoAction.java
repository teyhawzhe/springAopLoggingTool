package com.autolog.action.before.putMapping.impl;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.putMapping.PutMappingBeforeDoAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultPutMappingBeforeDoAction implements PutMappingBeforeDoAction {

	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.beforeDoActionImplInit(request, joinPoint);
	}

}
