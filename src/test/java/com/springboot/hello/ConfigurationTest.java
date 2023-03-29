package com.springboot.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {


    @Test
    void simpleTest(){

        assertThat(new Common()).isSameAs(new Common());
        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();
        assertThat(bean1).isSameAs(bean2);

    }

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();
        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        assertThat(bean1.common).isSameAs(bean2.common);
    }


    static class MyConfigProxy extends MyConfig{
        private Common common;
        @Override
        Common common() {

            if(this.common==null){
                System.out.println("null");
                this.common=super.common();
            }
            return this.common;
        }
    }


    @Test
    void proxyCommonMethod(){
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        assertThat(bean1.common).isSameAs(bean2.common);
    }



    @Configuration
    static class MyConfig{

        @Bean
         Common common(){
            return new Common();
        }

        @Bean
        Bean2 bean2(){
            return  new Bean2(common());
        }

        @Bean
        Bean1 bean1(){
            return new Bean1(common());
        }
    }



    static class Bean1 {

        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    };

    static class Bean2{
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common{

    }
}
