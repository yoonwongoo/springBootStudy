package com.springboot.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
public class JettyConfig {
    @Bean
    public ServletWebServerFactory jettyServletWebServerFactory(){

        return new JettyServletWebServerFactory();
    }
}