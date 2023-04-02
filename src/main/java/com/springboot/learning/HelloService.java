package com.springboot.learning;

public interface HelloService {
    String hello(String name);

    default int helloCount(String name){
        return 0;
    }
}
