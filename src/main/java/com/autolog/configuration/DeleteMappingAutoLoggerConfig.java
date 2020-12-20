package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.action.after.deleteMapping.DeleteMappingAfterDoAction;
import com.autolog.action.after.deleteMapping.DeleteMappingAfterEndAction;
import com.autolog.action.after.deleteMapping.DeleteMappingAfterStartAction;
import com.autolog.action.after.deleteMapping.impl.DefaultDeleteMappingAfterDoAction;
import com.autolog.action.after.deleteMapping.impl.DefaultDeleteMappingAfterEndAction;
import com.autolog.action.after.deleteMapping.impl.DefaultDeleteMappingAfterStartAction;
import com.autolog.action.before.deleteMapping.DeleteMappingBeforeDoAction;
import com.autolog.action.before.deleteMapping.DeleteMappingBeforeEndAction;
import com.autolog.action.before.deleteMapping.DeleteMappingBeforeStartAction;
import com.autolog.action.before.deleteMapping.impl.DefaultDeleteMappingBeforeDoAction;
import com.autolog.action.before.deleteMapping.impl.DefaultDeleteMappingBeforeEndAction;
import com.autolog.action.before.deleteMapping.impl.DefaultDeleteMappingBeforeStartAction;
import com.autolog.aop.DeleteMappingLoggingAop;
import com.autolog.monitor.after.deleteMapping.DeleteMappingAfterMonitor;
import com.autolog.monitor.after.deleteMapping.impl.DeleteMappingAfterMonitorImpl;
import com.autolog.monitor.before.deleteMapping.DeleteMappingBeforeMonitor;
import com.autolog.monitor.before.deleteMapping.impl.DeleteMappingBeforeMonitorImpl;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class DeleteMappingAutoLoggerConfig {

	@Bean
	@ConditionalOnMissingBean(DeleteMappingBeforeMonitor.class)
	public DeleteMappingBeforeMonitor deleteMappingBeforeMonitor() {
		return new DeleteMappingBeforeMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(DeleteMappingBeforeStartAction.class)
	public DeleteMappingBeforeStartAction deleteMappingBeforeStartAction() {
		return new DefaultDeleteMappingBeforeStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(DeleteMappingBeforeDoAction.class)
	public DeleteMappingBeforeDoAction deleteMappingBeforeDoActionBean() {
		return new DefaultDeleteMappingBeforeDoAction();
	}

	@Bean
	@ConditionalOnMissingBean(DeleteMappingBeforeEndAction.class)
	public DeleteMappingBeforeEndAction deleteMappingBeforeEndActionBean() {
		return new DefaultDeleteMappingBeforeEndAction();
	}
	
	//
	
	@Bean
	@ConditionalOnMissingBean(DeleteMappingAfterEndAction.class)
	public DeleteMappingAfterEndAction deleteMappingAfterEndActionBean() {
		return new DefaultDeleteMappingAfterEndAction();
	}
	

	@Bean
	@ConditionalOnMissingBean(DeleteMappingAfterMonitor.class)
	public DeleteMappingAfterMonitor deleteMappingAfterMonitor() {
		return new DeleteMappingAfterMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(DeleteMappingAfterStartAction.class)
	public DeleteMappingAfterStartAction deleteMappingAfterStartAction() {
		return new DefaultDeleteMappingAfterStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(DeleteMappingAfterDoAction.class)
	public DeleteMappingAfterDoAction deleteMappingAfterDoActionBean() {
		return new DefaultDeleteMappingAfterDoAction();
	}

	// aop

	@Bean
	public DeleteMappingLoggingAop deleteMappingLoggingAopBean() {
		return new DeleteMappingLoggingAop();
	}
	
}
