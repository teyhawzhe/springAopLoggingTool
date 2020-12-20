package com.autolog.configuration;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.autolog.aop.MybatisSqlAop;
import com.autolog.properties.MybatisLoggerSettingProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(MybatisLoggerSettingProperties.class)
@ConditionalOnProperty(prefix = "mybatis.interceptor", matchIfMissing = true, value = "enabled")
@EnableAspectJAutoProxy
public class MybatisAutoLoggerConfig {
	
	@Bean
	public Interceptor mybatisSqlAopBean() {
		return new MybatisSqlAop();
	}

}
