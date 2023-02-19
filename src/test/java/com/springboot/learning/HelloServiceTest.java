package com.springboot.learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloServiceTest {

    /*return prefix: Simple Hello Service*/
    @Test
    public void serviceTest(){
    HelloService helloService = new SimpleHelloService();
    String serviceResult =helloService.hello("1234");

        assertThat(serviceResult).isEqualTo("Simple Hello Service1234");

    }



    @Test
    void serviceDecoratorTest(){
        HelloDecorator helloDecorator = new HelloDecorator(hs->hs);

        String res = helloDecorator.hello("1234");

        assertThat(res).isEqualTo("***1234***");
    }
}
