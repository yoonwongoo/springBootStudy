package com.springboot.learning;


import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

/*    @Bean
    ServletWebServerFactory servletWebServerFactory(){
        JettyServletWebServerFactory jettyServletWebServerFactory = new JettyServletWebServerFactory();
        jettyServletWebServerFactory.setPort(9092);
        return jettyServletWebServerFactory;
    }*/
}
