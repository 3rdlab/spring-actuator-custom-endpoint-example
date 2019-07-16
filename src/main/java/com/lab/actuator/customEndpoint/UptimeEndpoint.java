package com.lab.actuator.customEndpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "uptime")
public class UptimeEndpoint {

    @ReadOperation
    public UpTimer getUptime(){
        return new UpTimer();
    }

}
