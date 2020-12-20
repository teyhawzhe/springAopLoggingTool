package com.autolog.monitor.before.getMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.getMapping.GetMappingBeforeDoAction;
import com.autolog.action.before.getMapping.GetMappingBeforeEndAction;
import com.autolog.action.before.getMapping.GetMappingBeforeStartAction;
import com.autolog.monitor.before.getMapping.GetMappingBeforeMonitor;

public class GetMappingBeforeMonitorImpl implements GetMappingBeforeMonitor {

	@Autowired
	private GetMappingBeforeStartAction getMappingBeforeStartAction; 
	
	@Autowired
	private GetMappingBeforeDoAction getMappingBeforeDoAction;
	
	@Autowired
	private GetMappingBeforeEndAction getMappingBeforeEndAction;
	
	@Override
	public void start(JoinPoint joinPoint) {
		getMappingBeforeStartAction.doing(joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint) {
		getMappingBeforeDoAction.doing(joinPoint);
	}

	@Override
	public void end(JoinPoint joinPoint) {
		getMappingBeforeEndAction.doing(joinPoint);
	}

}
