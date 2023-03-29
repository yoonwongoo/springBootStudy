package com.springboot.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/*condition에 대한 test*/
public class ConditionTest {


    @Test
    void conditionTest() {
        //true
        ApplicationContextRunner acr1 = new ApplicationContextRunner();
        acr1.withUserConfiguration(Config1.class).run(context -> assertThat(context).hasSingleBean(MyBean.class));



        //false
        ApplicationContextRunner acr2 = new ApplicationContextRunner();
        acr2.withUserConfiguration(Config2.class).run(context -> assertThat(context).doesNotHaveBean(MyBean.class));



   /*     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(Config1.class);
        ac.refresh();
        MyBean mybean1 = (MyBean) ac.getBean(MyBean.class);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(Config2.class);
        ac.refresh();
        MyBean mybean2 = (MyBean) ac.getBean(MyBean.class);*/
    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(TrueCondition.class)
    @interface TureCondition{}





    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanConditional.class)
    @interface BooleanCondition{
        boolean value();
    }


    @Configuration
    @BooleanCondition(true)
    static class Config1{
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    @Configuration
    @Conditional(FalseCondition.class)
    static class Config2{
        @Bean
        MyBean myBean(){
            return new MyBean();
        }
    }

    static class MyBean{



    }

    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }

    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

    static class BooleanConditional implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
         Map<String,Object> metaDataMap = metadata.getAnnotationAttributes(BooleanCondition.class.getName());
         Boolean value= (Boolean) metaDataMap.get("value");



         return value;


        }
    }
}