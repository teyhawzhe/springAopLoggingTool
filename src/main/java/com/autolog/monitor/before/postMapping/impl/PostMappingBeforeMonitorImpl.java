package com.autolog.monitor.before.postMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.postMapping.PostMappingBeforeDoAction;
import com.autolog.action.before.postMapping.PostMappingBeforeEndAction;
import com.autolog.action.before.postMapping.PostMappingBeforeStartAction;
import com.autolog.monitor.before.postMapping.PostMappingBeforeMonitor;

public class PostMappingBeforeMonitorImpl implements PostMappingBeforeMonitor {

	@Autowired
	private PostMappingBeforeStartAction postMappingBeforeStartAction; 
	
	@Autowired
	private PostMappingBeforeDoAction postMappingBeforeDoAction;
	
	@Autowired
	private PostMappingBeforeEndAction postMappingBeforeEndAction;
	
	@Override
	public void start(JoinPoint joinPoint) {
		postMappingBeforeStartAction.doing(joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint) {
		postMappingBeforeDoAction.doing(joinPoint);
	}

	@Override
	public void end(JoinPoint joinPoint) {
		postMappingBeforeEndAction.doing(joinPoint);
	}

}
