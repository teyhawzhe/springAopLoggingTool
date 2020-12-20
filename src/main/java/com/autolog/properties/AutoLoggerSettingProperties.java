package com.autolog.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "monitor")
public class AutoLoggerSettingProperties {

	private boolean postSwitcher = true;
	
	private boolean getSwitcher = true;
	
	private boolean deleteSwitcher = true;
	
	private boolean putSwitcher = true;
	
	private boolean serviceSwitcher = true;
}
