package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.action.after.getMapping.GetMappingAfterDoAction;
import com.autolog.action.after.getMapping.GetMappingAfterEndAction;
import com.autolog.action.after.getMapping.GetMappingAfterStartAction;
import com.autolog.action.after.getMapping.impl.DefaultGetMappingAfterDoAction;
import com.autolog.action.after.getMapping.impl.DefaultGetMappingAfterEndAction;
import com.autolog.action.after.getMapping.impl.DefaultGetMappingAfterStartAction;
import com.autolog.action.before.getMapping.GetMappingBeforeDoAction;
import com.autolog.action.before.getMapping.GetMappingBeforeEndAction;
import com.autolog.action.before.getMapping.GetMappingBeforeStartAction;
import com.autolog.action.before.getMapping.impl.DefaultGetMappingBeforeDoAction;
import com.autolog.action.before.getMapping.impl.DefaultGetMappingBeforeEndAction;
import com.autolog.action.before.getMapping.impl.DefaultGetMappingBeforeStartAction;
import com.autolog.aop.GetMappingLoggingAop;
import com.autolog.monitor.after.getMapping.GetMappingAfterMonitor;
import com.autolog.monitor.after.getMapping.impl.GetMappingAfterMonitorImpl;
import com.autolog.monitor.before.getMapping.GetMappingBeforeMonitor;
import com.autolog.monitor.before.getMapping.impl.GetMappingBeforeMonitorImpl;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class GetMappingAutoLoggerConfig {

	@Bean
	@ConditionalOnMissingBean(GetMappingBeforeMonitor.class)
	public GetMappingBeforeMonitor getMappingBeforeMonitor() {
		return new GetMappingBeforeMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(GetMappingBeforeStartAction.class)
	public GetMappingBeforeStartAction getMappingBeforeStartAction() {
		return new DefaultGetMappingBeforeStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(GetMappingBeforeDoAction.class)
	public GetMappingBeforeDoAction getMappingBeforeDoActionBean() {
		return new DefaultGetMappingBeforeDoAction();
	}

	@Bean
	@ConditionalOnMissingBean(GetMappingBeforeEndAction.class)
	public GetMappingBeforeEndAction getMappingBeforeEndActionBean() {
		return new DefaultGetMappingBeforeEndAction();
	}
	
	//
	
	@Bean
	@ConditionalOnMissingBean(GetMappingAfterEndAction.class)
	public GetMappingAfterEndAction getMappingAfterEndActionBean() {
		return new DefaultGetMappingAfterEndAction();
	}
	

	@Bean
	@ConditionalOnMissingBean(GetMappingAfterMonitor.class)
	public GetMappingAfterMonitor getMappingAfterMonitor() {
		return new GetMappingAfterMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(GetMappingAfterStartAction.class)
	public GetMappingAfterStartAction getMappingAfterStartAction() {
		return new DefaultGetMappingAfterStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(GetMappingAfterDoAction.class)
	public GetMappingAfterDoAction getMappingAfterDoActionBean() {
		return new DefaultGetMappingAfterDoAction();
	}

	// aop

	@Bean
	public GetMappingLoggingAop getMappingLoggingAopBean() {
		return new GetMappingLoggingAop();
	}
	
}
