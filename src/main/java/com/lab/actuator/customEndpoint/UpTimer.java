package com.lab.actuator.customEndpoint;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

public class UpTimer {
    
	public String getUptime() {
		
		RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		long uptime = rb.getUptime();
		
		return String.format("%02d:%02d:%02d", 
					TimeUnit.MILLISECONDS.toHours(uptime),
					TimeUnit.MILLISECONDS.toMinutes(uptime) % TimeUnit.HOURS.toMinutes(1),
					TimeUnit.MILLISECONDS.toSeconds(uptime) % TimeUnit.MINUTES.toSeconds(1));	
	}

}
