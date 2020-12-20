package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.action.after.postMapping.PostMappingAfterDoAction;
import com.autolog.action.after.postMapping.PostMappingAfterEndAction;
import com.autolog.action.after.postMapping.PostMappingAfterStartAction;
import com.autolog.action.after.postMapping.impl.DefaultPostMappingAfterDoAction;
import com.autolog.action.after.postMapping.impl.DefaultPostMappingAfterEndAction;
import com.autolog.action.after.postMapping.impl.DefaultPostMappingAfterStartAction;
import com.autolog.action.before.postMapping.PostMappingBeforeDoAction;
import com.autolog.action.before.postMapping.PostMappingBeforeEndAction;
import com.autolog.action.before.postMapping.PostMappingBeforeStartAction;
import com.autolog.action.before.postMapping.impl.DefaultPostMappingBeforeDoAction;
import com.autolog.action.before.postMapping.impl.DefaultPostMappingBeforeEndAction;
import com.autolog.action.before.postMapping.impl.DefaultPostMappingBeforeStartAction;
import com.autolog.aop.PostMappingLoggingAop;
import com.autolog.monitor.after.postMapping.PostMappingAfterMonitor;
import com.autolog.monitor.after.postMapping.impl.PostMappingAfterMonitorImpl;
import com.autolog.monitor.before.postMapping.PostMappingBeforeMonitor;
import com.autolog.monitor.before.postMapping.impl.PostMappingBeforeMonitorImpl;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class PostMappingAutoLoggerConfig {

	@Bean
	@ConditionalOnMissingBean(PostMappingBeforeMonitor.class)
	public PostMappingBeforeMonitor postMappingBeforeMonitor() {
		return new PostMappingBeforeMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(PostMappingBeforeStartAction.class)
	public PostMappingBeforeStartAction postMappingBeforeStartAction() {
		return new DefaultPostMappingBeforeStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(PostMappingBeforeDoAction.class)
	public PostMappingBeforeDoAction postMappingBeforeDoActionBean() {
		return new DefaultPostMappingBeforeDoAction();
	}

	@Bean
	@ConditionalOnMissingBean(PostMappingBeforeEndAction.class)
	public PostMappingBeforeEndAction postMappingBeforeEndActionBean() {
		return new DefaultPostMappingBeforeEndAction();
	}
	
	//
	
	@Bean
	@ConditionalOnMissingBean(PostMappingAfterEndAction.class)
	public PostMappingAfterEndAction postMappingAfterEndActionBean() {
		return new DefaultPostMappingAfterEndAction();
	}
	

	@Bean
	@ConditionalOnMissingBean(PostMappingAfterMonitor.class)
	public PostMappingAfterMonitor postMappingAfterMonitor() {
		return new PostMappingAfterMonitorImpl();
	}

	@Bean
	@ConditionalOnMissingBean(PostMappingAfterStartAction.class)
	public PostMappingAfterStartAction postMappingAfterStartAction() {
		return new DefaultPostMappingAfterStartAction();
	}

	@Bean
	@ConditionalOnMissingBean(PostMappingAfterDoAction.class)
	public PostMappingAfterDoAction postMappingAfterDoActionBean() {
		return new DefaultPostMappingAfterDoAction();
	}

	// aop

	@Bean
	public PostMappingLoggingAop postMappingLoggingAopBean() {
		return new PostMappingLoggingAop();
	}
	
}
