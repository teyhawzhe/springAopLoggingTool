package com.autolog.action.bean.https;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.HttpsAction;
import com.autolog.utils.HttpLogUtils;

public class RequestDoActionBean implements HttpsAction {

	@Autowired
	private HttpServletRequest request;

	@Override
	public void doing(JoinPoint joinPoint) {
		HttpLogUtils.action(request, joinPoint);
	}

	@Override
	public void doing(JoinPoint joinPoint, Object result) {
	
	}

}
