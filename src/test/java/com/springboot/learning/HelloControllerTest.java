package com.springboot.learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloControllerTest {


    @Test
    void HelloControllerTest(){

        HelloController helloController = new HelloController(hs->hs);
        String res = helloController.hello("1234");

        assertThat(res).isEqualTo("1234");

    }

    @Test
    void failHelloControllerTest(){
        HelloController helloController = new HelloController(hs->hs);

        assertThatThrownBy(()->{
             helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
             helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
