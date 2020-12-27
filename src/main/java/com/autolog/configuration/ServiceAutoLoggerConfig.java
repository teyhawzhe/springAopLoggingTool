package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import com.autolog.action.ServiceAction;
import com.autolog.action.bean.service.ServiceActionBean;
import com.autolog.aop.ServiceLoggingAop;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class ServiceAutoLoggerConfig {

	@Bean
	@Order(1)
	@ConditionalOnMissingBean(ServiceActionBean.class)
	public ServiceAction serviceActionBean() {
		return new ServiceActionBean();
	}
	
	@Bean
	public ServiceLoggingAop ServiceLoggingAopBean() {
		return new ServiceLoggingAop();
	}
 
}
