package com.autolog.monitor.after.deleteMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.after.deleteMapping.DeleteMappingAfterDoAction;
import com.autolog.action.after.deleteMapping.DeleteMappingAfterEndAction;
import com.autolog.action.after.deleteMapping.DeleteMappingAfterStartAction;
import com.autolog.monitor.after.deleteMapping.DeleteMappingAfterMonitor;

public class DeleteMappingAfterMonitorImpl implements DeleteMappingAfterMonitor {

	@Autowired
	private DeleteMappingAfterStartAction deleteMappingAfterStartAction; 
	
	@Autowired
	private DeleteMappingAfterDoAction deleteMappingAfterDoAction;
	
	@Autowired
	private DeleteMappingAfterEndAction deleteMappingAfterEndAction;
	
	@Override
	public void start(JoinPoint joinPoint, Object result) {
		deleteMappingAfterStartAction.doing(joinPoint,result);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		deleteMappingAfterDoAction.doing(joinPoint,result);
	}

	@Override
	public void end(JoinPoint joinPoint, Object result) {
		deleteMappingAfterEndAction.doing(joinPoint,result);
	}

}
