package com.springboot.learning;

public class ComplexHelloService implements HelloService{
    @Override
    public String hello(String name) {
        return "Complex Hello Service"+name;
    }

    @Override
    public int helloCount(String name) {
        return 0;
    }
}
