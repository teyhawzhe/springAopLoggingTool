package com.autolog.monitor.after.postMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.after.postMapping.PostMappingAfterDoAction;
import com.autolog.action.after.postMapping.PostMappingAfterEndAction;
import com.autolog.action.after.postMapping.PostMappingAfterStartAction;
import com.autolog.monitor.after.postMapping.PostMappingAfterMonitor;

public class PostMappingAfterMonitorImpl implements PostMappingAfterMonitor {

	@Autowired
	private PostMappingAfterStartAction postMappingAfterStartAction;

	@Autowired
	private PostMappingAfterDoAction postMappingAfterDoAction;

	@Autowired
	private PostMappingAfterEndAction postMappingAfterEndAction;

	@Override
	public void start(JoinPoint joinPoint, Object result) {
		postMappingAfterStartAction.doing(joinPoint,result);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		postMappingAfterDoAction.doing(joinPoint,result);
	}

	@Override
	public void end(JoinPoint joinPoint, Object result) {
		postMappingAfterEndAction.doing(joinPoint,result);
	}

}
