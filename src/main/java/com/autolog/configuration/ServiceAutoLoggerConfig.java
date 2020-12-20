package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.action.after.service.ServiceAfterDoAction;
import com.autolog.action.after.service.ServiceAfterEndAction;
import com.autolog.action.after.service.ServiceAfterStartAction;
import com.autolog.action.after.service.impl.DefaultServiceAfterDoAction;
import com.autolog.action.after.service.impl.DefaultServiceAfterEndAction;
import com.autolog.action.after.service.impl.DefaultServiceAfterStartAction;
import com.autolog.action.before.service.ServiceBeforeDoAction;
import com.autolog.action.before.service.ServiceBeforeEndAction;
import com.autolog.action.before.service.ServiceBeforeStartAction;
import com.autolog.action.before.service.impl.DefaultServiceBeforeDoAction;
import com.autolog.action.before.service.impl.DefaultServiceBeforeEndAction;
import com.autolog.action.before.service.impl.DefaultServiceBeforeStartAction;
import com.autolog.aop.ServiceLoggingAop;
import com.autolog.monitor.after.service.ServiceAfterMonitor;
import com.autolog.monitor.after.service.impl.ServiceAfterMonitorImpl;
import com.autolog.monitor.before.service.ServiceBeforeMonitor;
import com.autolog.monitor.before.service.impl.ServiceBeforeMonitorImpl;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class ServiceAutoLoggerConfig {

	// before
	
	@Bean
	@ConditionalOnMissingBean(ServiceBeforeMonitor.class)
	public ServiceBeforeMonitor serviceBeforeMonitor() {
		return new ServiceBeforeMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(ServiceBeforeStartAction.class)
	public ServiceBeforeStartAction serviceBeforeStartAction() {
		return new DefaultServiceBeforeStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(ServiceBeforeDoAction.class)
	public ServiceBeforeDoAction serviceBeforeDoActionBean() {
		return new DefaultServiceBeforeDoAction();
	}

	@Bean
	@ConditionalOnMissingBean(ServiceBeforeEndAction.class)
	public ServiceBeforeEndAction serviceBeforeEndActionBean() {
		return new DefaultServiceBeforeEndAction();
	}
	
	// end
	
	@Bean
	@ConditionalOnMissingBean(ServiceAfterEndAction.class)
	public ServiceAfterEndAction serviceAfterEndActionBean() {
		return new DefaultServiceAfterEndAction();
	}
	

	@Bean
	@ConditionalOnMissingBean(ServiceAfterMonitor.class)
	public ServiceAfterMonitor serviceAfterMonitor() {
		return new ServiceAfterMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(ServiceAfterStartAction.class)
	public ServiceAfterStartAction serviceAfterStartAction() {
		return new DefaultServiceAfterStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(ServiceAfterDoAction.class)
	public ServiceAfterDoAction serviceAfterDoActionBean() {
		return new DefaultServiceAfterDoAction();
	}

	// aop

	@Bean
	public ServiceLoggingAop serviceLoggingAopBean() {
		return new ServiceLoggingAop();
	}
	
}
