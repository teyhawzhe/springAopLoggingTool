package com.autolog.properties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "thread.local.class")
public class TheadLocalProperties {

		public boolean enable = true;
	
		private List<String> name = new ArrayList<>();
	
}
