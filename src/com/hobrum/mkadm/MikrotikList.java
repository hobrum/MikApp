package com.hobrum.mkadm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan("com.hobrum.mkadm")
@PropertySource("classpath:mikrotik.properties")
public class MikrotikList {

    @Value("#{'${ipMikrotikDevices}'.split(',')}")
    private List<String> ipMikrotikDevices;

    public List<String> getIpMikrotikDevices() {
        return ipMikrotikDevices;
    }

}
