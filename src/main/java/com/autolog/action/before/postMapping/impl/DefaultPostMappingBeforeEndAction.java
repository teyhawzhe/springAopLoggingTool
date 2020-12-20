package com.autolog.action.before.postMapping.impl;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autolog.action.before.postMapping.PostMappingBeforeEndAction;
import com.autolog.utils.InitBeforeAction;

public class DefaultPostMappingBeforeEndAction implements PostMappingBeforeEndAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		InitBeforeAction.postMappingBeforeEndActionImplInit(joinPoint);
	}

}
