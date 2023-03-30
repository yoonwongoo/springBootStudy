package com.springboot.config;

import org.springframework.stereotype.Component;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

    private String contextPath;

    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public ServerProperties(String contextPath, int port) {
        this.contextPath = contextPath;
        this.port = port;
    }

    public ServerProperties() {
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
