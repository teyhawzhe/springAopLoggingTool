package com.autolog.monitor.before.putMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.putMapping.PutMappingBeforeDoAction;
import com.autolog.action.before.putMapping.PutMappingBeforeEndAction;
import com.autolog.action.before.putMapping.PutMappingBeforeStartAction;
import com.autolog.monitor.before.putMapping.PutMappingBeforeMonitor;

public class PutMappingBeforeMonitorImpl implements PutMappingBeforeMonitor {

	@Autowired
	private PutMappingBeforeStartAction putMappingBeforeStartAction; 
	
	@Autowired
	private PutMappingBeforeDoAction putMappingBeforeDoAction;
	
	@Autowired
	private PutMappingBeforeEndAction putMappingBeforeEndAction;
	
	@Override
	public void start(JoinPoint joinPoint) {
		putMappingBeforeStartAction.doing(joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint) {
		putMappingBeforeDoAction.doing(joinPoint);
	}

	@Override
	public void end(JoinPoint joinPoint) {
		putMappingBeforeEndAction.doing(joinPoint);
	}

}
