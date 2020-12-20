package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.action.after.putMapping.PutMappingAfterDoAction;
import com.autolog.action.after.putMapping.PutMappingAfterEndAction;
import com.autolog.action.after.putMapping.PutMappingAfterStartAction;
import com.autolog.action.after.putMapping.impl.DefaultPutMappingAfterDoAction;
import com.autolog.action.after.putMapping.impl.DefaultPutMappingAfterEndAction;
import com.autolog.action.after.putMapping.impl.DefaultPutMappingAfterStartAction;
import com.autolog.action.before.putMapping.PutMappingBeforeDoAction;
import com.autolog.action.before.putMapping.PutMappingBeforeEndAction;
import com.autolog.action.before.putMapping.PutMappingBeforeStartAction;
import com.autolog.action.before.putMapping.impl.DefaultPutMappingBeforeDoAction;
import com.autolog.action.before.putMapping.impl.DefaultPutMappingBeforeEndAction;
import com.autolog.action.before.putMapping.impl.DefaultPutMappingBeforeStartAction;
import com.autolog.aop.PutMappingLoggingAop;
import com.autolog.monitor.after.putMapping.PutMappingAfterMonitor;
import com.autolog.monitor.after.putMapping.impl.PutMappingAfterMonitorImpl;
import com.autolog.monitor.before.putMapping.PutMappingBeforeMonitor;
import com.autolog.monitor.before.putMapping.impl.PutMappingBeforeMonitorImpl;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class PutMappingAutoLoggerConfig {

	@Bean
	@ConditionalOnMissingBean(PutMappingBeforeMonitor.class)
	public PutMappingBeforeMonitor putMappingBeforeMonitor() {
		return new PutMappingBeforeMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(PutMappingBeforeStartAction.class)
	public PutMappingBeforeStartAction putMappingBeforeStartAction() {
		return new DefaultPutMappingBeforeStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(PutMappingBeforeDoAction.class)
	public PutMappingBeforeDoAction putMappingBeforeDoActionBean() {
		return new DefaultPutMappingBeforeDoAction();
	}

	@Bean
	@ConditionalOnMissingBean(PutMappingBeforeEndAction.class)
	public PutMappingBeforeEndAction putMappingBeforeEndActionBean() {
		return new DefaultPutMappingBeforeEndAction();
	}
	
	//
	
	@Bean
	@ConditionalOnMissingBean(PutMappingAfterEndAction.class)
	public PutMappingAfterEndAction putMappingAfterEndActionBean() {
		return new DefaultPutMappingAfterEndAction();
	}
	

	@Bean
	@ConditionalOnMissingBean(PutMappingAfterMonitor.class)
	public PutMappingAfterMonitor putMappingAfterMonitor() {
		return new PutMappingAfterMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(PutMappingAfterStartAction.class)
	public PutMappingAfterStartAction putMappingAfterStartAction() {
		return new DefaultPutMappingAfterStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(PutMappingAfterDoAction.class)
	public PutMappingAfterDoAction putMappingAfterDoActionBean() {
		return new DefaultPutMappingAfterDoAction();
	}

	// aop

	@Bean
	public PutMappingLoggingAop putMappingLoggingAopBean() {
		return new PutMappingLoggingAop();
	}
	
}
