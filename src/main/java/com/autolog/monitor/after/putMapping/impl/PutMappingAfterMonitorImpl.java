package com.autolog.monitor.after.putMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.after.putMapping.PutMappingAfterDoAction;
import com.autolog.action.after.putMapping.PutMappingAfterEndAction;
import com.autolog.action.after.putMapping.PutMappingAfterStartAction;
import com.autolog.monitor.after.putMapping.PutMappingAfterMonitor;

public class PutMappingAfterMonitorImpl implements PutMappingAfterMonitor {

	@Autowired
	private PutMappingAfterStartAction putMappingAfterStartAction;

	@Autowired
	private PutMappingAfterDoAction putMappingAfterDoAction;

	@Autowired
	private PutMappingAfterEndAction putMappingAfterEndAction;
	
	@Override
	public void start(JoinPoint joinPoint, Object result) {
		putMappingAfterStartAction.doing(joinPoint,result);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		putMappingAfterDoAction.doing(joinPoint,result);
	}

	@Override
	public void end(JoinPoint joinPoint, Object result) {
		putMappingAfterEndAction.doing(joinPoint,result);
	}

}
