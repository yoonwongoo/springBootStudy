package com.springboot.config.autoconfig;

import com.springboot.config.ConditionMyOnClass;
import com.springboot.config.MyAutoConfiguration;
import com.springboot.config.ServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionMyOnClass("org.apache.catalina.startup.Tomcat")
@Import(ServerProperties.class)

public class TomcatConfig {
    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory tomcatServletWebServerFactory() {

        return new TomcatServletWebServerFactory();
    }


}