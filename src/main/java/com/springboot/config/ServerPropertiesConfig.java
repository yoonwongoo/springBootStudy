package com.springboot.config;


import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@MyAutoConfiguration
public class ServerPropertiesConfig {

/*    @Bean
    public ServerProperties serverProperties(Environment environment){
      *//*  return new ServerProperties(environment.getProperty("contextPath"),Integer.parseInt(environment.getProperty("port")));*//*
        return Binder.get(environment).bind("",ServerProperties.class).get();
    }*/
}

