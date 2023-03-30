package com.springboot.config.autoconfig;

import com.springboot.config.ConditionMyOnClass;
import com.springboot.config.EnableMyConfigurationProperties;
import com.springboot.config.MyAutoConfiguration;
import com.springboot.config.ServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionMyOnClass("org.eclipse.jetty.server.Server")
@EnableMyConfigurationProperties(ServerProperties.class)
public class JettyConfig {


 /*   @Value("${contextPath}")
    private String contextPath;

    @Value("${port:9002}")
    private int port;*/
    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory jettyServletWebServerFactory(ServerProperties serverProperties){
        JettyServletWebServerFactory jettyServletWebServerFactory = new JettyServletWebServerFactory();
/*
        String contextPath = environments.getProperty("contextPath");
        jettyServletWebServerFactory.setContextPath(contextPath);
        jettyServletWebServerFactory.setPort(port);

*/
        jettyServletWebServerFactory.setPort(serverProperties.getPort());
        jettyServletWebServerFactory.setContextPath(serverProperties.getContextPath());

        return jettyServletWebServerFactory;
    }
}