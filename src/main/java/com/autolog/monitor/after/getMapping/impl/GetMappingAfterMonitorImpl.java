package com.autolog.monitor.after.getMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.after.getMapping.GetMappingAfterDoAction;
import com.autolog.action.after.getMapping.GetMappingAfterEndAction;
import com.autolog.action.after.getMapping.GetMappingAfterStartAction;
import com.autolog.monitor.after.getMapping.GetMappingAfterMonitor;

public class GetMappingAfterMonitorImpl implements GetMappingAfterMonitor {

	@Autowired
	private GetMappingAfterStartAction getMappingAfterStartAction; 
	
	@Autowired
	private GetMappingAfterDoAction getMappingAfterDoAction;
	
	@Autowired
	private GetMappingAfterEndAction getMappingAfterEndAction;
	
	@Override
	public void start(JoinPoint joinPoint, Object result) {
		getMappingAfterStartAction.doing(joinPoint,result);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		getMappingAfterDoAction.doing(joinPoint,result);
	}

	@Override
	public void end(JoinPoint joinPoint, Object result) {
		getMappingAfterEndAction.doing(joinPoint,result);
	}

}
