package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.exceptionHandler.ExceptionHandler;
import com.autolog.exceptionHandler.impl.ExceptionHandlerImpl;
import com.autolog.properties.AutoLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AutoLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class ExceptionAutoLoggerConfig {

	@Bean
	@ConditionalOnMissingBean(ExceptionHandler.class)
	public ExceptionHandler exceptionHandlerBean() {
		return new ExceptionHandlerImpl();
	}

}
