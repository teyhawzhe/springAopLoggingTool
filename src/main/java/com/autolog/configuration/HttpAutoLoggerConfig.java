package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import com.autolog.action.HttpsAction;
import com.autolog.action.bean.https.RequestDoActionBean;
import com.autolog.action.bean.https.RequestEndActionBean;
import com.autolog.action.bean.https.RequestStartActionBean;
import com.autolog.aop.RequestLoggingAop;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class HttpAutoLoggerConfig {

	@Bean
	@Order(1)
	@ConditionalOnMissingBean(RequestStartActionBean.class)
	public HttpsAction requestStartActionBean() {
		return new RequestStartActionBean();
	}
	
	
	@Bean
	@Order(2)
	@ConditionalOnMissingBean(RequestDoActionBean.class)
	public HttpsAction requestDoActionBean() {
		return new RequestDoActionBean();
	}
	
	@Bean
	@Order(3)
	@ConditionalOnMissingBean(RequestEndActionBean.class)
	public HttpsAction requestEndActionBean() {
		return new RequestEndActionBean();
	}
	
	@Bean
	public RequestLoggingAop requestLoggingAopBean() {
		return new RequestLoggingAop();
	}

}
