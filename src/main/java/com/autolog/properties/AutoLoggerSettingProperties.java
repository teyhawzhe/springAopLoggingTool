package com.autolog.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "monitor")
public class AutoLoggerSettingProperties {

	private boolean httpsSwitcher = true;
	
	private boolean serviceSwitcher = true;
}
