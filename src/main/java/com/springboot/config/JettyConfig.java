package com.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionMyOnClass("org.eclipse.jetty.server.Server")
public class JettyConfig {
    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory jettyServletWebServerFactory(){
        return new JettyServletWebServerFactory();
    }
}