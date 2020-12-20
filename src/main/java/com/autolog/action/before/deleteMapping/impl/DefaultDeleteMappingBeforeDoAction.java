package com.autolog.action.before.deleteMapping.impl;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.deleteMapping.DeleteMappingBeforeDoAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultDeleteMappingBeforeDoAction implements DeleteMappingBeforeDoAction {

	@Autowired
	private HttpServletRequest request;

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.beforeDoActionImplInit(request, joinPoint);
	}

}
