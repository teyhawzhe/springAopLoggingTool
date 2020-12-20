package com.autolog.monitor.before.service.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.service.ServiceBeforeDoAction;
import com.autolog.action.before.service.ServiceBeforeEndAction;
import com.autolog.action.before.service.ServiceBeforeStartAction;
import com.autolog.monitor.before.service.ServiceBeforeMonitor;

public class ServiceBeforeMonitorImpl implements ServiceBeforeMonitor {

	@Autowired
	private ServiceBeforeStartAction serviceBeforeStartAction;

	@Autowired
	private ServiceBeforeDoAction serviceBeforeDoAction;

	@Autowired
	private ServiceBeforeEndAction serviceBeforeEndAction;

	@Override
	public void start(JoinPoint joinPoint) {
		serviceBeforeStartAction.doing(joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint) {
		serviceBeforeDoAction.doing(joinPoint);
	}

	@Override
	public void end(JoinPoint joinPoint) {
		serviceBeforeEndAction.doing(joinPoint);
	}

}
