package com.hobrum.mkadm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.hobrum.mkadm")
@PropertySource("classpath:users.properties")
public class MikrotikUser {

    @Value("${user.mikrotik}")
    private String userMikrotik;

    @Value("${password.mikrotik}")
    private String passwordMikrotik;

    public String getUserMikrotik() {
        return userMikrotik;
    }

    public String getPasswordMikrotik() {
        return passwordMikrotik;
    }
}
