package com.autolog.monitor.after.service.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.after.service.ServiceAfterDoAction;
import com.autolog.action.after.service.ServiceAfterEndAction;
import com.autolog.action.after.service.ServiceAfterStartAction;
import com.autolog.monitor.after.service.ServiceAfterMonitor;

public class ServiceAfterMonitorImpl implements ServiceAfterMonitor {

	@Autowired
	private ServiceAfterStartAction serviceAfterStartAction;

	@Autowired
	private ServiceAfterDoAction serviceAfterDoAction;

	@Autowired
	private ServiceAfterEndAction serviceAfterEndAction;
	
	@Override
	public void start(JoinPoint joinPoint, Object result) {
		serviceAfterStartAction.doing(joinPoint,result);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		serviceAfterDoAction.doing(joinPoint,result);
	}

	@Override
	public void end(JoinPoint joinPoint, Object result) {
		serviceAfterEndAction.doing(joinPoint,result);
	}

}
