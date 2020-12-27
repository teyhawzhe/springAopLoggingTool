package com.autolog.action.bean.https;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.HttpsAction;
import com.autolog.utils.HttpLogUtils;

public class RequestEndActionBean implements HttpsAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		
	}
	
	@Override
	public void doing(JoinPoint joinPoint, Object result) {
		HttpLogUtils.after(joinPoint, result);
	}

	
}
