package com.autolog.action.before.getMapping.impl;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.getMapping.GetMappingBeforeDoAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultGetMappingBeforeDoAction implements GetMappingBeforeDoAction {

	@Autowired
	private HttpServletRequest request;

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.beforeDoActionImplInit(request, joinPoint);
	}

}
