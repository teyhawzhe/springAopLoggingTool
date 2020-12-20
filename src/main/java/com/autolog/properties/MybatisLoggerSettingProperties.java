package com.autolog.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "mybatis.interceptor")
public class MybatisLoggerSettingProperties {

	private boolean switcher = true;
	
}
