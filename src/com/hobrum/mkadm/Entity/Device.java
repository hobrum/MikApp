package com.hobrum.mkadm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Device() {
    }

    public Device(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

}
