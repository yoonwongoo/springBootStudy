package com.springboot.learning;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HelloDecorator implements HelloService{

    private final HelloService helloService;


    public HelloDecorator(HelloService helloService){
        this.helloService =helloService;
    }
    @Override
    public String hello(String name) {
        return "***"+helloService.hello(name)+"***";
    }

    @Override
    public int helloCount(String name) {
        return helloService.helloCount(name);
      }
}
