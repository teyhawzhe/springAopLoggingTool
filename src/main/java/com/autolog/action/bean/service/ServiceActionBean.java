package com.autolog.action.bean.service;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.ServiceAction;
import com.autolog.utils.ServiceLogUtils;

public class ServiceActionBean implements ServiceAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		ServiceLogUtils.before(joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		ServiceLogUtils.after(joinPoint,result);
	}

}
