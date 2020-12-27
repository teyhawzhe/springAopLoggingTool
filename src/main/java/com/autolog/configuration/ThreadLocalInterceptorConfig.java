package com.autolog.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.action.ThreadLocalInterceptor;
import com.autolog.action.bean.threadLocal.DefaultThreadLocalInterceptorBean;
import com.autolog.properties.TheadLocalProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(TheadLocalProperties.class)
@ConditionalOnProperty(prefix = "monitor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class ThreadLocalInterceptorConfig {

	@Bean
	@ConditionalOnMissingBean(ThreadLocalInterceptor.class)
	public ThreadLocalInterceptor threadLocalInterceptorBean() {
		return new DefaultThreadLocalInterceptorBean();
	}

}
