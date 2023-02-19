package com.springboot.learning;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleHelloService implements HelloService {
    @Override
    public String hello(String name){

        return "Simple Hello Service"+name;
    }
}
