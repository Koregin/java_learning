package sks.nagios;

import java.util.Date;
import java.util.Map;

public class Host {
    String hostname;
    String state;
    String ping;
    Map<String, String> services;

    public Host(String hostname, String state, String ping) {
        this.hostname = hostname;
        this.state = state;
        this.ping = ping;
    }

    public String getHostname() {
        return hostname;
    }

    @Override
    public String toString() {
        return "Host{" +
                "hostname='" + hostname + '\'' +
                ", state='" + state + '\'' +
                ", ping='" + ping + '\'' +
                '}';
    }
}
