package com.autolog.action.bean.https;

import org.aspectj.lang.JoinPoint;

import com.autolog.action.HttpsAction;
import com.autolog.utils.HttpLogUtils;

public class RequestStartActionBean implements HttpsAction {

	@Override
	public void doing(JoinPoint joinPoint) {
		HttpLogUtils.before(joinPoint, "start http aop logging");
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {

	}

}
