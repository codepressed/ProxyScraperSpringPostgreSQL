package com.rionacko.proxyScraperDB.proxy;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Proxy implements Serializable {
    @Id
    @SequenceGenerator(
            name = "proxy_sequence",
            sequenceName = "proxy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proxy_sequence"
    )
    private Integer id;
    private String ip;
    private Integer port;
    private String location;
    private String ms;
    private String proxyType;
    private String safety;

    public Proxy(){
    }

    public Proxy(Integer id, String ip, int port, String location, String ms, String proxyType, String safety) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.location = location;
        this.ms = ms;
        this.proxyType = proxyType;
        this.safety = safety;
    }

    public Proxy(String ip, int port, String location, String ms, String proxyType, String safety) {
        this.ip = ip;
        this.port = port;
        this.location = location;
        this.ms = ms;
        this.proxyType = proxyType;
        this.safety = safety;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getProxyType() {
        return proxyType;
    }

    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proxy proxy = (Proxy) o;
        return Objects.equals(port, proxy.port) &&
                Objects.equals(id, proxy.id) &&
                Objects.equals(ip, proxy.ip) &&
                Objects.equals(location, proxy.location) &&
                Objects.equals(ms, proxy.ms) &&
                Objects.equals(proxyType, proxy.proxyType) &&
                Objects.equals(safety, proxy.safety);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ip, port, location, ms, proxyType, safety);
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", location='" + location + '\'' +
                ", ms='" + ms + '\'' +
                ", proxyType='" + proxyType + '\'' +
                ", safety='" + safety + '\'' +
                '}';
    }
}
