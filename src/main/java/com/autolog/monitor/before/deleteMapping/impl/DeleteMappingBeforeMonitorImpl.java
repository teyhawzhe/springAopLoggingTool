package com.autolog.monitor.before.deleteMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.deleteMapping.DeleteMappingBeforeDoAction;
import com.autolog.action.before.deleteMapping.DeleteMappingBeforeEndAction;
import com.autolog.action.before.deleteMapping.DeleteMappingBeforeStartAction;
import com.autolog.monitor.before.deleteMapping.DeleteMappingBeforeMonitor;

public class DeleteMappingBeforeMonitorImpl implements DeleteMappingBeforeMonitor {

	@Autowired
	private DeleteMappingBeforeStartAction deleteMappingBeforeStartAction; 
	
	@Autowired
	private DeleteMappingBeforeDoAction deleteMappingBeforeDoAction;
	
	@Autowired
	private DeleteMappingBeforeEndAction deleteMappingBeforeEndAction;
	
	@Override
	public void start(JoinPoint joinPoint) {
		deleteMappingBeforeStartAction.doing(joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint) {
		deleteMappingBeforeDoAction.doing(joinPoint);
	}

	@Override
	public void end(JoinPoint joinPoint) {
		deleteMappingBeforeEndAction.doing(joinPoint);
	}

}
