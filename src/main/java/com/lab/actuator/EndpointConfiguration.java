package com.lab.actuator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.lab.actuator.customEndpoint.UptimeEndpoint;

@Configuration
public class EndpointConfiguration {

	@Bean
	@Description("Display Application's Uptime")
	public UptimeEndpoint uptimeEndpoint() {
		return new UptimeEndpoint();
	}
	
}
